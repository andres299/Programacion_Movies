package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Movie_Languages;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Movie_GenresRepo extends JpaRepository<Movie_Languages, Long> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM movie_genres WHERE genre_id = :entityId", nativeQuery = true)
    void deleteByGenreId(@Param("entityId") int entityId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM movie_genres WHERE movie_id = :movieId", nativeQuery = true)
    void deleteByMovieId(int movieId);
}
