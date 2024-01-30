package com.esliceu.demoMovies.DTO;

import java.util.List;

public class InfoMovies {

    private int movieId;
    private String title;
    private List<String> actorName;
    private List<String> directorName;
    private List<String> characterName;
    private List<String> genre;

    public InfoMovies() {
    }

    public InfoMovies(int movieId, String title, List<String> actorName, List<String> directorName, List<String> characterName, List<String> genre) {
        this.movieId = movieId;
        this.title = title;
        this.actorName = actorName;
        this.directorName = directorName;
        this.characterName = characterName;
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

    public List<String> getActorName() {
        return actorName;
    }

    public void setActorName(List<String> actorName) {
        this.actorName = actorName;
    }

    public List<String> getDirectorName() {
        return directorName;
    }

    public void setDirectorName(List<String> directorName) {
        this.directorName = directorName;
    }

    public List<String> getCharacterName() {
        return characterName;
    }

    public void setCharacterName(List<String> characterName) {
        this.characterName = characterName;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }
}
