package com.esliceu.demoMovies.Entities;

import java.io.Serializable;

public class Movie_CastId implements Serializable {
    private Movie movie;

    private Person person;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
