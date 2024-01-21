package com.esliceu.demoMovies.Entities;

import java.io.Serializable;

public class Movie_GenresId implements Serializable {
    private Movie movie;
    private Genre genre;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
