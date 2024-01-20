package com.esliceu.demoMovies.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int language_id;

    private String language_code;

    private String language_name;

    @OneToMany(mappedBy = "language")
    @JsonIgnore
    private Set<Movie_Languages> movieLanguages;

    public Language() {
    }

    public Language(String language_code, String language_name) {
        this.language_code = language_code;
        this.language_name = language_name;
    }

    public Language(int language_id, String language_code, String language_name) {
        this.language_id = language_id;
        this.language_code = language_code;
        this.language_name = language_name;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public String getLanguage_code() {
        return language_code;
    }

    public void setLanguage_code(String language_code) {
        this.language_code = language_code;
    }

    public String getLanguage_name() {
        return language_name;
    }

    public void setLanguage_name(String language_name) {
        this.language_name = language_name;
    }

    public Set<Movie_Languages> getMovieLanguages() {
        return movieLanguages;
    }

    public void setMovieLanguages(Set<Movie_Languages> movieLanguages) {
        this.movieLanguages = movieLanguages;
    }
}
