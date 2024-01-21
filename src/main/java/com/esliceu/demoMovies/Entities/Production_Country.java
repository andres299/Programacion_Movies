package com.esliceu.demoMovies.Entities;

import jakarta.persistence.*;

@Entity
@Table(
        name = "production_country",
        uniqueConstraints =
        @UniqueConstraint(columnNames = {"movie_id", "country_id"})
)
@IdClass(Production_Country_Id.class)
public class Production_Country {

    @Id
    @ManyToOne
    @JoinColumn(name = "movie_id")
    Movie movie;

    @Id
    @ManyToOne
    @JoinColumn(name = "country_id")
    Country country;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
    /*
    @EmbeddedId
    private ProductionCountryId id;

    @ManyToOne
    Movie movie;

    @ManyToOne
    Country country;

    public ProductionCountryId getId() {
        return id;
    }

    public void setId(ProductionCountryId id) {
        this.id = id;
    }
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
     */
}
