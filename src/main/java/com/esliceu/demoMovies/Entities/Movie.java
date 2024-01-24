package com.esliceu.demoMovies.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="movie_id")
    int movieId;
    String title;
    int budget;
    String homepage;
    String overview;
    BigDecimal popularity;
    String release_date;
    Long revenue;
    int runtime;
    String movie_status;
    String tagline;
    double vote_average;
    int vote_count;

    @OneToMany(mappedBy = "movie")
    @JsonIgnore
    private Set<Movie_Cast> moviecast;
    @JsonIgnore
    @OneToMany(mappedBy = "movie")
    Set<Production_Country> productionCountries;

    @JsonIgnore
    @OneToMany(mappedBy = "movie")
    private Set<Movie_Company> movieCompanies;

    @JsonIgnore
    @OneToMany(mappedBy = "movie")
    private Set<Movie_Crew> movieCrews;

    @JsonIgnore
    @OneToMany(mappedBy = "movie")
    private Set<Movie_Genres> movieGenres;

    @JsonIgnore
    @OneToMany(mappedBy = "movie")
    private Set<Movie_Keywords> movieKeywords;

    @JsonIgnore
    @OneToMany(mappedBy = "movie")
    private Set<Movie_Languages> movieLanguages;

    public Movie() {
    }

    public Movie(String title, int budget, String homepage, String overview, BigDecimal popularity, String release_date, Long revenue, int runtime, String movie_status, String tagline, double vote_average, int vote_count) {
        this.title = title;
        this.budget = budget;
        this.homepage = homepage;
        this.overview = overview;
        this.popularity = popularity;
        this.release_date = release_date;
        this.revenue = revenue;
        this.runtime = runtime;
        this.movie_status = movie_status;
        this.tagline = tagline;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }
    public Movie(int movieId,String title, int budget, String homepage, String overview, BigDecimal popularity, String release_date, Long revenue, int runtime, String movie_status, String tagline, double vote_average, int vote_count) {
        this.movieId = movieId;
        this.title = title;
        this.budget = budget;
        this.homepage = homepage;
        this.overview = overview;
        this.popularity = popularity;
        this.release_date = release_date;
        this.revenue = revenue;
        this.runtime = runtime;
        this.movie_status = movie_status;
        this.tagline = tagline;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

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

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
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

    public Set<Movie_Keywords> getMovieKeywords() {
        return movieKeywords;
    }

    public void setMovieKeywords(Set<Movie_Keywords> movieKeywords) {
        this.movieKeywords = movieKeywords;
    }

    public Set<Movie_Languages> getMovieLanguages() {
        return movieLanguages;
    }

    public void setMovieLanguages(Set<Movie_Languages> movieLanguages) {
        this.movieLanguages = movieLanguages;
    }
}
