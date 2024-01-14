package com.esliceu.demoMovies.Entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gender_id;

    private String gender;

    @OneToMany(mappedBy = "gender")
    private List<MovieCast> moviecast;

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

    public List<MovieCast> getMoviecast() {
        return moviecast;
    }

    public void setMoviecast(List<MovieCast> moviecast) {
        this.moviecast = moviecast;
    }
}
