package com.esliceu.demoMovies.DTO;

import java.util.List;
import java.util.Map;

public class InfoMovies {

    private int movieId;
    private String title;
    private List<String> directorName;
    private Map<String, String> actorCharacterPairs;
    private List<String> genre;

    public InfoMovies() {
    }

    public InfoMovies(int movieId, String title, List<String> directorName, Map<String, String> actorCharacterPairs, List<String> genre) {
        this.movieId = movieId;
        this.title = title;
        this.directorName = directorName;
        this.actorCharacterPairs = actorCharacterPairs;
        this.genre = genre;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getDirectorName() {
        return directorName;
    }

    public void setDirectorName(List<String> directorName) {
        this.directorName = directorName;
    }

    public Map<String, String> getActorCharacterPairs() {
        return actorCharacterPairs;
    }

    public void setActorCharacterPairs(Map<String, String> actorCharacterPairs) {
        this.actorCharacterPairs = actorCharacterPairs;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }
}
