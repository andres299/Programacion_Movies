package com.esliceu.demoMovies.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private int languageId;

    @Column(name = "language_code")
    private String languageCode;

    @Column(name = "language_name")
    private String languageName;

    @OneToMany(mappedBy = "language")
    @JsonIgnore
    private Set<Movie_Languages> movieLanguages;

    public Language() {
    }

    public Language(String languageCode, String languageName) {
        this.languageCode = languageCode;
        this.languageName = languageName;
    }

    public Language(int languageId, String languageCode, String languageName) {
        this.languageId = languageId;
        this.languageCode = languageCode;
        this.languageName = languageName;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public Set<Movie_Languages> getMovieLanguages() {
        return movieLanguages;
    }

    public void setMovieLanguages(Set<Movie_Languages> movieLanguages) {
        this.movieLanguages = movieLanguages;
    }
}
