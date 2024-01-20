package com.esliceu.demoMovies.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Gender {
    @Id
    private int gender_id;

    private String gender;

    @OneToMany(mappedBy = "gender")
    @JsonIgnore
    private Set<Movie_Cast> moviecast;

    public Gender() {
    }

    public Gender(int gender_id, String gender) {
        this.gender_id = gender_id;
        this.gender = gender;
    }

    public int getGender_id() {
        return gender_id;
    }

    public void setGender_id(int gender_id) {
        this.gender_id = gender_id;
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
