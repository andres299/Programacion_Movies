package com.esliceu.demoMovies.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int department_id;

    private String department_name;

    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private Set<Movie_Crew> movieCrews;

    public Department() {
    }

    public Department(String department_name) {
        this.department_name = department_name;
    }

    public Department(int department_id, String department_name) {
        this.department_id = department_id;
        this.department_name = department_name;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public Set<Movie_Crew> getMovieCrews() {
        return movieCrews;
    }

    public void setMovieCrews(Set<Movie_Crew> movieCrews) {
        this.movieCrews = movieCrews;
    }
}
