package com.esliceu.demoMovies.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Gender {
    @Id
    @Column(name = "gender_id")
    private int genderId;

    private String gender;

    @OneToMany(mappedBy = "gender")
    @JsonIgnore
    private Set<Movie_Cast> moviecast;

    public Gender() {
    }

    public Gender(int genderId, String gender) {
        this.genderId = genderId;
        this.gender = gender;
    }

    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<Movie_Cast> getMoviecast() {
        return moviecast;
    }

    public void setMoviecast(Set<Movie_Cast> moviecast) {
        this.moviecast = moviecast;
    }
}
