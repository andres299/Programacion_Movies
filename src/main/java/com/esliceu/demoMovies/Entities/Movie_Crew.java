package com.esliceu.demoMovies.Entities;

import jakarta.persistence.*;
@Entity
@Table(
        name = "movie_crew",
        uniqueConstraints =
        @UniqueConstraint(columnNames = {"movie_id", "person_id ", "department_id"})
)
@IdClass(Movie_CrewId.class)
public class Movie_Crew {

    @Id
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Id
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
    @Id
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Id
    private String job;

    public Movie_Crew() {
    }

    public Movie_Crew(Movie movie, Person person, Department department, String job) {
        this.movie = movie;
        this.person = person;
        this.department = department;
        this.job = job;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getJob() {
        return job;
    }
}