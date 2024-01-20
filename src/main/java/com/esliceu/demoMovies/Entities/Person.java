package com.esliceu.demoMovies.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Person {
    @Id
    private int person_id;
    private String person_name;
    @OneToMany(mappedBy = "person")
    @JsonIgnore
    private Set<Movie_Cast> moviecast;

    @OneToMany(mappedBy = "person")
    @JsonIgnore
    private Set<Movie_Crew> movieCrews;

    public Person() {
    }

    public Person(int person_id, String person_name) {
        this.person_id = person_id;
        this.person_name = person_name;
    }

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

    public Set<Movie_Cast> getMoviecast() {
        return moviecast;
    }

    public void setMoviecast(Set<Movie_Cast> moviecast) {
        this.moviecast = moviecast;
    }

    public Set<Movie_Crew> getMovieCrews() {
        return movieCrews;
    }

    public void setMovieCrews(Set<Movie_Crew> movieCrews) {
        this.movieCrews = movieCrews;
    }
}
