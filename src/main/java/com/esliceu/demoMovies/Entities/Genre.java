package com.esliceu.demoMovies.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Genre {
    @Id
    @Column(name = "genre_id")
    private int genreId;

    @Column(name = "genre_name")
    private String genreName;

    @OneToMany(mappedBy = "genre")
    @JsonIgnore
    private Set<Movie_Genres> movieGenres;

    public Genre() {
    }

    public Genre(int genreId, String genreName) {
        this.genreId = genreId;
        this.genreName = genreName;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
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
