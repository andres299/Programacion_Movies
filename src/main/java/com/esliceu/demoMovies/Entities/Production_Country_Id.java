package com.esliceu.demoMovies.Entities;

import java.io.Serializable;

public class Production_Country_Id implements Serializable {
    private Integer movie;
    private Integer country;

    public Integer getMovie() {
        return movie;
    }

    public void setMovie(Integer movie) {
        this.movie = movie;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }
}
