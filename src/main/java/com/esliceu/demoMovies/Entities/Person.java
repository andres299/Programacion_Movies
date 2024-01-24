package com.esliceu.demoMovies.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Person {
    @Id
    @Column(name = "person_id")
    private int personId;
    @Column(name = "person_name")
    private String personName;
    @OneToMany(mappedBy = "person")
    @JsonIgnore
    private Set<Movie_Cast> moviecast;

    @OneToMany(mappedBy = "person")
    @JsonIgnore
    private Set<Movie_Crew> movieCrews;

    public Person() {
    }

    public Person(int personId, String personName) {
        this.personId = personId;
        this.personName = personName;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
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
