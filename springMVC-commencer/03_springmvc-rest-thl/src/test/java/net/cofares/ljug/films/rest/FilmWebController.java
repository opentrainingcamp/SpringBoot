package net.cofares.ljug.films.rest;

import net.cofares.ljug.films.rest.FilmController;
import net.cofares.ljug.films.Film;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import net.cofares.ljug.films.FilmService;

@RunWith(SpringRunner.class)
@WebMvcTest(FilmController.class)
public class FilmWebController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FilmService filmService;

    @Test
    public void shouldReturnListOfBooks() throws Exception {

        when(filmService.findAll()).thenReturn(Arrays.asList(new Film("123", "Cours C2", "Pascal Fares", "Auditeurs"),
            new Film("321", "Cours C1", "Pascal E Fares", "Auditeur 1", "Auditeur 2")));

        mockMvc.perform(get("/restfilms"))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
            .andExpect(MockMvcResultMatchers.jsonPath("$[*].imdb", Matchers.containsInAnyOrder("123", "321")))
            .andExpect(MockMvcResultMatchers.jsonPath("$[*].directeur", Matchers.containsInAnyOrder("Pascal Fares","Pascal E Fares")))
            .andExpect(MockMvcResultMatchers.jsonPath("$[*].title", Matchers.containsInAnyOrder("Cours C1", "Cours C2")));
    }

    @Test
    public void shouldReturn404WhenBookNotFound() throws Exception {

        when(filmService.find(anyString())).thenReturn(Optional.empty());

        mockMvc.perform(get("/restfilms/123"))
            .andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturnBookWhenFound() throws Exception {

        when(filmService.find(anyString())).thenReturn(Optional.of(new Film("123", "Spring 5 Recipes", "Marten Deinum", "Josh Long")));

        mockMvc.perform(get("/restfilms/123"))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.imdb", Matchers.equalTo("123")))
            .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.equalTo("Spring 5 Recipes")));
    }

    @Test
    public void shouldAddBook() throws Exception {

        when(filmService.create(any(Film.class))).thenReturn(new Film("123456789", "Test Film enregitré", "Pascal Fares", "Pascal et Fares"));

        mockMvc.perform(post("/restfilms")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{ \"imdb\" : \"123456789\"}, \"title\" : \"Test Film enregitré\", \"directeur\" : \"Pascal Fares\",\"authors\" : [\"Pascal et Fares\"]"))
            .andExpect(status().isCreated())
            .andExpect(header().string("Location", "http://localhost/films/123456789"));
    }

}
