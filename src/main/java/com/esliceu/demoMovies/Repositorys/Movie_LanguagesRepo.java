package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Administrator;
import com.esliceu.demoMovies.Entities.Movie_Languages;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Movie_LanguagesRepo extends JpaRepository<Movie_Languages, Long> {
    // Obtiene una lista de Movie_Languages por ID de idioma.
    List<Movie_Languages> findAllByLanguage_LanguageId(int entityId);
    // Obtiene una lista de Movie_Languages por ID de rol de idioma.
    List<Movie_Languages> findAllByLanguageRole_RoleId(int entityId);
    // Obtiene una lista de Movie_Languages por ID de película.
    List<Movie_Languages> findAllByMovie_MovieId(int movieId);
}
