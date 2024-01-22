package com.esliceu.demoMovies.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Genre {
    @Id
    private int genre_id;

    @Column(name = "genre_name")
    private String genreName;

    @OneToMany(mappedBy = "genre")
    @JsonIgnore
    private Set<Movie_Genres> movieGenres;

    public Genre() {
    }

    public Genre(int genre_id, String genreName) {
        this.genre_id = genre_id;
        this.genreName = genreName;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public Set<Movie_Genres> getMovieGenres() {
        return movieGenres;
    }

    public void setMovieGenres(Set<Movie_Genres> movieGenres) {
        this.movieGenres = movieGenres;
    }
}
