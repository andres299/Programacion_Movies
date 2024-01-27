package com.esliceu.demoMovies.Entities;

import jakarta.persistence.*;

@Entity
@Table(
        name = "movie_cast",
        uniqueConstraints =
        @UniqueConstraint(columnNames = {"movie_id", "person_id", "gender_id"})
)
@IdClass(Movie_CastId.class)
public class Movie_Cast {

    @Id
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Id
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Id
    @Column(name="character_name")
    private String characterName;

    @Id
    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    private int cast_order;

    public Movie_Cast() {
    }

    public Movie_Cast(Movie movie, Person person, String characterName) {
        this.movie = movie;
        this.person = person;
        this.characterName = characterName;
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

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getCast_order() {
        return cast_order;
    }

    public void setCast_order(int cast_order) {
        this.cast_order = cast_order;
    }
}