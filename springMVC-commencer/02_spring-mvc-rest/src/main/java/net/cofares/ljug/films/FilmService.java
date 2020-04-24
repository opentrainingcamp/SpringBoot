package net.cofares.ljug.films;

import java.util.Optional;

public interface FilmService {

	Iterable<Film> findAll();
	Film create(Film film);
	Optional<Film> find(String imdb);
}
