package net.cofares.ljug.films.rest;

import net.cofares.ljug.films.Film;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import net.cofares.ljug.films.FilmService;

@RestController
@RequestMapping("/films")
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

    //:8080/films/tt00112233 // films?imdb=tt000... 
    @GetMapping("/{imdb}")
    public ResponseEntity<Film> get(@PathVariable("imdb") String imdb) {
        //status 200 ou 404
        return filmService.find(imdb)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<Film> create(@RequestBody Film film,
        UriComponentsBuilder uriBuilder) {
        Film created = filmService.create(film);
        URI newBookUri = uriBuilder.path("/films/{imdb}").build(created.getImdb());
        //201 (created) status response
        return ResponseEntity
            .created(newBookUri)
            .body(created);
    }
}
