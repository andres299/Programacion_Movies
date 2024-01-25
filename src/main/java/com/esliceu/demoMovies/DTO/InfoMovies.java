package com.esliceu.demoMovies.DTO;

import com.esliceu.demoMovies.Entities.Genre;
import com.esliceu.demoMovies.Entities.Movie_Cast;
import com.esliceu.demoMovies.Entities.Person;

import java.util.List;

public class InfoMovies {
    private String title;
    private List<Person> actorName;
    private List<Person> direactorName;
    private List<Movie_Cast> characterName;
    private List<Genre> genre;

    public InfoMovies() {
    }

    public InfoMovies(String title, List<Person> actorName, List<Person> direactorName, List<Movie_Cast> characterName, List<Genre> genre) {
        this.title = title;
        this.actorName = actorName;
        this.direactorName = direactorName;
        this.characterName = characterName;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Person> getActorName() {
        return actorName;
    }

    public void setActorName(List<Person> actorName) {
        this.actorName = actorName;
    }

    public List<Person> getDireactorName() {
        return direactorName;
    }

    public void setDireactorName(List<Person> direactorName) {
        this.direactorName = direactorName;
    }

    public List<Movie_Cast> getCharacterName() {
        return characterName;
    }

    public void setCharacterName(List<Movie_Cast> characterName) {
        this.characterName = characterName;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }
}
