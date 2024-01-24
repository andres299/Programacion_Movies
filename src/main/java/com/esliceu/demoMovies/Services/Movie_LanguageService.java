package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Repositorys.Movie_LanguagesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Movie_LanguageService {
    @Autowired
    Movie_LanguagesRepo movieLanguagesRepo;

    public void deleteByLanguageId(int entityId) {
        movieLanguagesRepo.deleteByLanguageId(entityId);
    }

    public void deleteByLanguageRoleId(int entityId) {
        movieLanguagesRepo.deleteByLanguageRoleId(entityId);
    }

    public void deleteByMovieId(int movieId) { movieLanguagesRepo.deleteByMovieId(movieId); }
}
