package net.cofares.ljug.films.web;

import net.cofares.ljug.films.Film;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import net.cofares.ljug.films.FilmService;
import net.cofares.ljug.films.rest.FilmController;
import org.junit.Ignore;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(FilmThController.class)
public class FilmControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FilmService filmService;

    @Test
    public void shouldReturnListOfBooks() throws Exception {

        when(filmService.findAll()).thenReturn(Arrays.asList(new Film("123", "Cours C2", "Pascal Fares", "Auditeurs"),
            new Film("321", "Cours C1", "Pascal E Fares", "Auditeur 1", "Auditeur 2")));

        mockMvc.perform(get("/films"))
            .andExpect(status().isOk()).andExpect(view().name("films/list"))
            .andExpect(model().attribute("films", Matchers.hasSize(2)));
    }

    @Test
    @Ignore
    public void shouldReturn404WhenBookNotFound() throws Exception {

        when(filmService.find(anyString())).thenReturn(Optional.empty());

        mockMvc.perform(get("/films").param("imdb", "123"))
            .andExpect(status().isOk())
            .andExpect(view().name("films/details"))
            .andExpect(model().attributeDoesNotExist("film"));
    }

    

}
