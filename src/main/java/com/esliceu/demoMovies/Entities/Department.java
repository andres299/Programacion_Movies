package com.esliceu.demoMovies.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int department_id;

    @Column(name = "department_name")
    private String departmentName;

    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private Set<Movie_Crew> movieCrews;

    public Department() {
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department(int department_id, String departmentName) {
        this.department_id = department_id;
        this.departmentName = departmentName;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Set<Movie_Crew> getMovieCrews() {
        return movieCrews;
    }

    public void setMovieCrews(Set<Movie_Crew> movieCrews) {
        this.movieCrews = movieCrews;
    }
}
