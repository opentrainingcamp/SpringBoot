package net.cofares.ljug.films;

import net.cofares.ljug.films.EnMemoireFilmsService;
import net.cofares.ljug.films.Film;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EnMemoireFilmsServiceTest {

	private EnMemoireFilmsService service;

	@Before
	public void setup() {
		this.service = new EnMemoireFilmsService();
	}

	@Test
	public void shouldReturnEmptyOptionalWhenNotFound() {
		assertThat(service.find("1234")).isEmpty();
	}

	@Test
	public void shouldFindAfterCreation() {
		assertThat(service.findAll()).isEmpty();

		Film film = new Film("1234", "Pour exemple", "Pascal Fares", "Mes auditeurs");
		assertThat(service.create(film)).isEqualTo(film);
		assertThat(service.find(film.getImdb())).contains(film);

	}

	@Test
	public void shouldReturnAllBooksAfterCreation() {
		assertThat(service.findAll()).isEmpty();

		Film film1 = new Film("1234", "Spring 5 Recipes", "Marten Deinum", "Josh Long");
		Film film2 = new Film("4321", "Spring Boot 2 Recipes", "Marten Deinum");
		service.create(film1);
		service.create(film2);

		assertThat(service.findAll()).containsExactly(film1, film2);


	}

}
