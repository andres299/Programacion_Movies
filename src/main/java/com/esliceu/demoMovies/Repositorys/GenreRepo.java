package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Genre;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepo extends JpaRepository<Genre, Long> {
    // Obtiene el primer registro de género ordenado por el ID de manera descendente.
    Genre findFirstByOrderByGenreIdDesc();
    // Cuenta la cantidad de géneros con un ID específico.
    int countGenresByGenreId(int entityId);
    // Busca géneros cuyos nombres comienzan con una palabra clave dada, admitiendo paginación.
    List<Genre> findByGenreNameStartingWithIgnoreCase(String keyword, Pageable pageable);
    // Busca géneros asociados a una película específica identificada por su ID.
    List<Genre> findGenreByMovieGenres_MovieMovieIdEquals(int movieId);

    Genre findByGenreNameEquals(String select);
}
