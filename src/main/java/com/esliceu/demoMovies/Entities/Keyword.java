package com.esliceu.demoMovies.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Keyword {
    @Id
    private int keyword_id;

    private String keyword_name;

    @OneToMany(mappedBy = "keyword")
    @JsonIgnore
    private Set<Movie_Keywords> movieKeywords;

    public Keyword() {
    }

    public Keyword(int keyword_id, String keyword_name) {
        this.keyword_id = keyword_id;
        this.keyword_name = keyword_name;
    }

    public int getKeyword_id() {
        return keyword_id;
    }

    public void setKeyword_id(int keyword_id) {
        this.keyword_id = keyword_id;
    }

    public String getKeyword_name() {
        return keyword_name;
    }

    public void setKeyword_name(String keyword_name) {
        this.keyword_name = keyword_name;
    }

    public Set<Movie_Keywords> getMovieKeywords() {
        return movieKeywords;
    }

    public void setMovieKeywords(Set<Movie_Keywords> movieKeywords) {
        this.movieKeywords = movieKeywords;
    }
}
