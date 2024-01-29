package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Genre;
import com.esliceu.demoMovies.Repositorys.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    @Autowired
    GenreRepo genreRepo;
    // Obtiene todas las entidades Genre paginadas.
    public List<?> findAll(Pageable pageable) {
        return genreRepo.findAll(pageable).getContent();
    }
    // Obtiene el primer género ordenado por ID de forma descendente.
    public Genre findFirstByOrderByGenreIdDesc() {
        return genreRepo.findFirstByOrderByGenreIdDesc();
    }
    // Elimina un género por su ID.
    public void deleteById(long entityId) {
        genreRepo.deleteById(entityId);
    }
    // Guarda un nuevo género.
    public void save(Genre genre) {
        genreRepo.save(genre);
    }
    // Cuenta la cantidad de géneros con un ID específico.
    public int countGenresByGenreId(int entityId) {
        return genreRepo.countGenresByGenreId(entityId);
    }
    // Busca géneros cuyos nombres comienzan con la palabra clave proporcionada.
    public List<?> findByGenreNameStartingWithIgnoreCase(String keyword, Pageable pageable) {
        return genreRepo.findByGenreNameStartingWithIgnoreCase(keyword,pageable);
    }
    // Obtiene los géneros asociados a una película por su ID.
    public List<Genre> findGenreByMovieGenres_MovieMovieIdEquals(int movieId) {
        return genreRepo.findGenreByMovieGenres_MovieMovieIdEquals(movieId);
    }

    public Genre findByGenreNameEquals(String select) {
        return genreRepo.findByGenreNameEquals(select);
    }
}
