package com.esliceu.demoMovies.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Keyword {
    @Id
    @Column(name = "keyword_id")
    private int keywordId;

    @Column(name = "keyword_name")
    private String keywordName;

    @OneToMany(mappedBy = "keyword")
    @JsonIgnore
    private Set<Movie_Keywords> movieKeywords;

    public Keyword() {
    }

    public Keyword(int keywordId, String keywordName) {
        this.keywordId = keywordId;
        this.keywordName = keywordName;
    }

    public int getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(int keywordId) {
        this.keywordId = keywordId;
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
