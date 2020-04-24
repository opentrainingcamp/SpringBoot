package net.cofares.ljug.films.rest;

import net.cofares.ljug.films.Film;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import net.cofares.ljug.films.FilmService;

@RestController
@RequestMapping("/restfilms")
public class FilmController {

    private final FilmService filmService;

    //ici seul contruteur : filmSerce est injecté
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public Iterable<Film> all() {
        return filmService.findAll();
    }

    @GetMapping("/{imdb}")
    public ResponseEntity<Film> get(@PathVariable("imdb") String imdb) {
        return filmService.find(imdb)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<Film> create(@RequestBody Film film,
        UriComponentsBuilder uriBuilder) {
        Film created = filmService.create(film);
        URI newBookUri = uriBuilder.path("/films/{imdb}").build(created.getImdb());
        return ResponseEntity
            .created(newBookUri)
            .body(created);
    }
}
