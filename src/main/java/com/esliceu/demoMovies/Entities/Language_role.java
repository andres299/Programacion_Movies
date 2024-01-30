package com.esliceu.demoMovies.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Language_role {
    @Id
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "language_role")
    private String languageRole;

    @OneToMany(mappedBy = "languageRole")
    @JsonIgnore
    private Set<Movie_Languages> movieLanguages;

    public Language_role() {
    }

    public Language_role(int roleId, String languageRole) {
        this.roleId = roleId;
        this.languageRole = languageRole;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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
