package com.esliceu.demoMovies.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Keyword {
    @Id
    private int keyword_id;

    @Column(name = "keyword_name")
    private String keywordName;

    @OneToMany(mappedBy = "keyword")
    @JsonIgnore
    private Set<Movie_Keywords> movieKeywords;

    public Keyword() {
    }

    public Keyword(int keyword_id, String keywordName) {
        this.keyword_id = keyword_id;
        this.keywordName = keywordName;
    }

    public int getKeyword_id() {
        return keyword_id;
    }

    public void setKeyword_id(int keyword_id) {
        this.keyword_id = keyword_id;
    }

    public String getKeywordName() {
        return keywordName;
    }

    public void setKeywordName(String keywordName) {
        this.keywordName = keywordName;
    }

    public Set<Movie_Keywords> getMovieKeywords() {
        return movieKeywords;
    }

    public void setMovieKeywords(Set<Movie_Keywords> movieKeywords) {
        this.movieKeywords = movieKeywords;
    }
}
