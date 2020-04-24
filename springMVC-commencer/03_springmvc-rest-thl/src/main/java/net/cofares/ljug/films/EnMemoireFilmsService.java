package net.cofares.ljug.films;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
class EnMemoireFilmsService implements FilmService {

	private final Map<String, Film> films = new ConcurrentHashMap<>();

	@Override
	public Iterable<Film> findAll() {
		return films.values();
	}

	@Override
	public Film create(Film film) {
		films.put(film.getImdb(), film);
		return film;
	}

	@Override
	public Optional<Film> find(String imdb) {
		return Optional.ofNullable(films.get(imdb));
	}
}
