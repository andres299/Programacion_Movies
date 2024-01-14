package com.esliceu.demoMovies.Entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movie_id;
    private String title;
    private int budget;
    private String homepage;
    private String overview;
    private BigDecimal popularity;
    private String release_date;
    private Long revenue;
    private int runtime;
    private String movie_status;
    private String tagline;
    private BigDecimal vote_average;
    private int vote_count;
    @OneToMany(mappedBy = "movie")
    private Set<Movie_Cast> moviecast;
    @OneToMany(mappedBy = "movie")
    private Set<Production_Country> productionCountries;

    @OneToMany(mappedBy = "movie")
    private Set<Movie_Company> movieCompanies;

    @OneToMany(mappedBy = "movie")
    private Set<Movie_Crew> movieCrews;

    @OneToMany(mappedBy = "movie")
    private Set<Movie_Genres> movieGenres;

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public BigDecimal getPopularity() {
        return popularity;
    }

    public void setPopularity(BigDecimal popularity) {
        this.popularity = popularity;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public Long getRevenue() {
        return revenue;
    }

    public void setRevenue(Long revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getMovie_status() {
        return movie_status;
    }

    public void setMovie_status(String movie_status) {
        this.movie_status = movie_status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public BigDecimal getVote_average() {
        return vote_average;
    }

    public void setVote_average(BigDecimal vote_average) {
        this.vote_average = vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public Set<Movie_Cast> getMoviecast() {
        return moviecast;
    }

    public void setMoviecast(Set<Movie_Cast> moviecast) {
        this.moviecast = moviecast;
    }

    public Set<Production_Country> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(Set<Production_Country> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public Set<Movie_Company> getMovieCompanies() {
        return movieCompanies;
    }

    public void setMovieCompanies(Set<Movie_Company> movieCompanies) {
        this.movieCompanies = movieCompanies;
    }

    public Set<Movie_Crew> getMovieCrews() {
        return movieCrews;
    }

    public void setMovieCrews(Set<Movie_Crew> movieCrews) {
        this.movieCrews = movieCrews;
    }

    public Set<Movie_Genres> getMovieGenres() {
        return movieGenres;
    }

    public void setMovieGenres(Set<Movie_Genres> movieGenres) {
        this.movieGenres = movieGenres;
    }
}
