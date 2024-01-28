package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Movie_Languages;
import com.esliceu.demoMovies.Repositorys.Movie_LanguagesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Movie_LanguageService {
    @Autowired
    Movie_LanguagesRepo movieLanguagesRepo;

    // Elimina registros de Movie_Languages asociados a un idioma específico, identificado por su ID (entityId).
    public void deleteByLanguageId(int entityId) {
        List<Movie_Languages> allMovieLanguages= movieLanguagesRepo.findAllByLanguage_LanguageId(entityId);
        movieLanguagesRepo.deleteAll(allMovieLanguages);
    }

    // Elimina registros de Movie_Languages asociados a un rol de idioma específico, identificado por su ID (entityId).
    public void deleteByLanguageRoleId(int entityId) {
        List<Movie_Languages> allMovieLanguages= movieLanguagesRepo.findAllByLanguageRole_RoleId(entityId);
        movieLanguagesRepo.deleteAll(allMovieLanguages);
    }

    // Elimina registros de Movie_Languages asociados a una película específica, identificada por su ID (movieId).
    public void deleteByMovieId(int movieId) {
        List<Movie_Languages> allMovieLanguages= movieLanguagesRepo.findAllByMovie_MovieId(movieId);
        movieLanguagesRepo.deleteAll(allMovieLanguages);
    }
}
