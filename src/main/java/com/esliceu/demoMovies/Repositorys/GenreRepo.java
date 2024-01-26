package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Genre;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepo extends JpaRepository<Genre, Long> {

    Genre findFirstByOrderByGenreIdDesc();

    int countGenresByGenreId(int entityId);

    List<Genre> findByGenreNameStartingWithIgnoreCase(String keyword, Pageable pageable);

    List<Genre> findGenreByMovieGenres_MovieMovieIdEquals(int movieId);
}
