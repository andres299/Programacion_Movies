package com.esliceu.demoMovies.Entities;

import jakarta.persistence.*;

@Entity
@Table(
        name = "movie_genres",
        uniqueConstraints =
        @UniqueConstraint(columnNames = {"movie_id", "genre_id"})
)
public class Movie_Genres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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