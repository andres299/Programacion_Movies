package com.esliceu.demoMovies.Entities;

import java.io.Serializable;

public class Movie_CompanyId implements Serializable {
    private Movie movie;
    private Production_Company company;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Production_Company getCompany() {
        return company;
    }

    public void setCompany(Production_Company company) {
        this.company = company;
    }
}
