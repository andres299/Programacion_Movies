package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GenreRepo extends JpaRepository<Genre, Long> {

    Genre findFirstByOrderByGenreIdDesc();

    int countGenresByGenreId(int entityId);

    List<Genre> findByGenreNameStartingWithIgnoreCase(String keyword);

    List<Genre> findGenreByMovieGenres_MovieMovieIdEquals(int movieId);
}
