package com.esliceu.demoMovies.Entities;

import java.io.Serializable;

public class Movie_LanguagesId implements Serializable {
    private Movie movie;
    private Language language;
    private Language_role languageRole;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Language_role getLanguageRole() {
        return languageRole;
    }

    public void setLanguageRole(Language_role languageRole) {
        this.languageRole = languageRole;
    }
}
