package net.cofares.ljug.films;

import java.util.*;

public class Film {

    private String imdb;
    private String title;
    private String directeur;
    private List<String> authors = new ArrayList<>();

    public Film() {
    }
    // new Film("tt0011.."", "mon film", "Moi et vous", "aut1", "aut2", "aut3")
    public Film(String imdb, String title, String directeur, String... authors) {
        this.imdb = imdb;
        this.title = title;
        this.directeur = directeur;
        this.authors.addAll(Arrays.asList(authors));
    }

    public String getImdb() {
        return imdb;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return Collections.unmodifiableList(authors);
    }

    public String getDirecteur() {
        return directeur;
    }

    public void setDirecteur(String directeur) {
        this.directeur = directeur;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Film film = (Film) o;
        return Objects.equals(imdb, film.imdb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imdb);
    }

    @Override
    public String toString() {
        return String.format("Film [imdb=%s, title=%s, directeur=%s, authors=%s]",
            this.imdb, this.title, this.directeur, this.authors);
    }
}
