package com.esliceu.demoMovies.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genre_id;

    private String genre_name;

    @OneToMany(mappedBy = "genre")
    @JsonIgnore
    private Set<Movie_Genres> movieGenres;

    public Genre() {
    }

    public Genre(int genre_id, String genre_name) {
        this.genre_id = genre_id;
        this.genre_name = genre_name;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    public Set<Movie_Genres> getMovieGenres() {
        return movieGenres;
    }

    public void setMovieGenres(Set<Movie_Genres> movieGenres) {
        this.movieGenres = movieGenres;
    }
}
