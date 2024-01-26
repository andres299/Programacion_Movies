package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface MovieRepo extends JpaRepository<Movie, Long> {

    Page<Movie> findByTitleStartingWithIgnoreCase(String keyword, Pageable pageable);

    Page<Movie> findMovieByMoviecast_PersonPersonNameContaining(String keyword, Pageable pageable);

    Page<Movie> findMovieByMovieGenres_GenreGenreNameContaining(String character_name, Pageable pageable);

    Page<Movie> findMovieByMoviecastCharacterNameContaining(String keyword, Pageable pageable);

    Page<Movie> findDistincMovieByMovieCrewsJobAndMovieCrews_PersonPersonNameContaining(String director, String keyword, Pageable pageable);

    @Query(value = "SELECT movie_id, title, overview, popularity, release_date, revenue FROM movie WHERE title LIKE %:keyword%", nativeQuery = true)
    List<Map<String, Object>> findByTitleSelectInfo(@Param("keyword") String keyword);

    int countMoviesByMovieId(int entityId);
}
