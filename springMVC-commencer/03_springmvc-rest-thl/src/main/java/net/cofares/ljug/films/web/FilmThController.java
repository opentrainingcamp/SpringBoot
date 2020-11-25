package net.cofares.ljug.films.web;

import net.cofares.ljug.films.Film;
import net.cofares.ljug.films.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FilmThController {

    private final FilmService filmService;

    public FilmThController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/films")
    public String all(Model model) {
        model.addAttribute("films", filmService.findAll());
        return "films/list";
    }

    @GetMapping(value = "/films", params = "imdb")
    public String get(@RequestParam("imdb") String imdb, Model model) {

        filmService.find(imdb)
            .ifPresent(film -> model.addAttribute("film", film));

        return "films/details";
    }

}
