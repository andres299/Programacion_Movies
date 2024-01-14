package com.esliceu.demoMovies.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int person_id;
    private String person_name;
    @OneToMany(mappedBy = "person")
    private List<MovieCast> moviecast;

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public List<MovieCast> getMoviecast() {
        return moviecast;
    }

    public void setMoviecast(List<MovieCast> moviecast) {
        this.moviecast = moviecast;
    }
}
