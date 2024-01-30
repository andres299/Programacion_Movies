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
    // Busca películas cuyos títulos comienzan con una palabra clave dada, admitiendo paginación.
    Page<Movie> findByTitleStartingWithIgnoreCase(String keyword, Pageable pageable);
    // Busca películas por el nombre de la persona en el reparto, admitiendo paginación.
    Page<Movie> findMovieByMoviecast_PersonPersonNameContaining(String keyword, Pageable pageable);
    // Busca películas por el nombre del género, admitiendo paginación.
    Page<Movie> findMovieByMovieGenres_GenreGenreNameContaining(String character_name, Pageable pageable);
    // Busca películas por el nombre del personaje en el reparto, admitiendo paginación.
    Page<Movie> findMovieByMoviecastCharacterNameContaining(String keyword, Pageable pageable);
    // Busca películas por el nombre del director, admitiendo paginación.
    Page<Movie> findDistincMovieByMovieCrewsJobAndMovieCrews_PersonPersonNameContaining(String director, String keyword, Pageable pageable);
    // Cuenta la cantidad de películas que tienen un ID específico.
    int countMoviesByMovieId(int entityId);
}
