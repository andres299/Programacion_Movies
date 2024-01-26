package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Keyword;
import com.esliceu.demoMovies.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface MovieRepo extends JpaRepository<Movie, Long> {
    List<Movie> findByTitleStartingWithIgnoreCase(String keyword);

    List<Movie> findMovieByMoviecast_PersonPersonNameContaining(String keyword);

    List<Movie> findMovieByMovieGenres_GenreGenreNameContaining(String character_name);

    List<Movie> findMovieByMoviecastCharacterNameContaining(String keyword);

    List<Movie> findDistincMovieByMovieCrewsJobAndMovieCrews_PersonPersonNameContaining(String director,String keyword);

    @Query(value = "SELECT movie_id ,title, overview,popularity,release_date,revenue FROM movie", nativeQuery = true)
    List<Map<String, Object>> findInfoMovies();

    @Query(value = "SELECT movie_id, title, overview, popularity, release_date, revenue FROM movie WHERE title LIKE %:keyword%", nativeQuery = true)
    List<Map<String, Object>> findByTitleSelectInfo(@Param("keyword") String keyword);

    int countMoviesByMovieId(int entityId);
}
