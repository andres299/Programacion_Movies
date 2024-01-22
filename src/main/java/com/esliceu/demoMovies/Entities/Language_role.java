package com.esliceu.demoMovies.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Language_role {
    @Id
    private int role_id;

    @Column(name = "language_role")
    private String languageRole;

    @OneToMany(mappedBy = "languageRole")
    @JsonIgnore
    private Set<Movie_Languages> movieLanguages;

    public Language_role() {
    }

    public Language_role(int role_id, String languageRole) {
        this.role_id = role_id;
        this.languageRole = languageRole;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getLanguageRole() {
        return languageRole;
    }

    public void setLanguageRole(String languageRole) {
        this.languageRole = languageRole;
    }

    public Set<Movie_Languages> getMovieLanguages() {
        return movieLanguages;
    }

    public void setMovieLanguages(Set<Movie_Languages> movieLanguages) {
        this.movieLanguages = movieLanguages;
    }
}
