package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Movie_Genres;
import com.esliceu.demoMovies.Entities.Movie_Languages;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Movie_GenresRepo extends JpaRepository<Movie_Genres, Long> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM movie_genres WHERE movie_id = :movieId", nativeQuery = true)
    void deleteByMovieId(int movieId);

    List<Movie_Genres> findAllByGenre_GenreId(int entityId);
}
