package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepo extends JpaRepository<Movie, Long> {
    List<Movie> findByTitleStartingWithIgnoreCase(String keyword);

    List<Movie> findMovieByMoviecast_PersonPersonNameContaining(String keyword);

    List<Movie> findMovieByMovieGenres_GenreGenreNameContaining(String character_name);

    List<Movie> findMovieByMoviecastCharacterNameContaining(String keyword);

    List<Movie> findDistincMovieByMovieCrewsJobAndMovieCrews_PersonPersonNameContaining(String director,String keyword);

}
