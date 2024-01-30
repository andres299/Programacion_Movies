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
    // Obtiene una lista de Movie_Genres por ID de película.
    List<Movie_Genres> findAllByMovie_MovieId(int movieId);
    // Obtiene una lista de Movie_Genres por ID de género.
    List<Movie_Genres> findAllByGenre_GenreId(int entityId);
}
