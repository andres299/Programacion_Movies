package com.esliceu.demoMovies.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Language_role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int role_id;

    private String language_role;

    @OneToMany(mappedBy = "languageRole")
    @JsonIgnore
    private Set<Movie_Languages> movieLanguages;

    public Language_role() {
    }

    public Language_role(int role_id, String language_role) {
        this.role_id = role_id;
        this.language_role = language_role;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getLanguage_role() {
        return language_role;
    }

    public void setLanguage_role(String language_role) {
        this.language_role = language_role;
    }

    public Set<Movie_Languages> getMovieLanguages() {
        return movieLanguages;
    }

    public void setMovieLanguages(Set<Movie_Languages> movieLanguages) {
        this.movieLanguages = movieLanguages;
    }
}
