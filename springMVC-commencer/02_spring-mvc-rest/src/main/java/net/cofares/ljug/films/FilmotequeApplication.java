package net.cofares.ljug.films;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FilmotequeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilmotequeApplication.class, args);
    }

    @Bean
    public ApplicationRunner filmsInitializer(FilmService filmService) {
        return args -> {
            filmService.create(new Film("tt0120737",
                "Le seigneur des anneaux: La communauté de l'anneau", "Peter Jackson",
                "J.R.R. Tolkien", "Fran Walsh (screenplay)", "Philippa Boyens (screenplay)"));
            filmService.create(new Film("tt1620981",
                "La famille Adams", "Greg Tiernan, Conrad Vernon ",
                "Matt Lieberman",
                "Erica Rivinoja", "Conrad Vernon", "Charles Addams", "Pamela Pettler"));
            filmService.create(new Film("tt0077687",
                "Le Hobbit",
                "Jules Bass, Arthur Rankin Jr",
                "J.R.R. Tolkien", "Romeo Muller (adapted for the screen)"));
        };

    }
}
