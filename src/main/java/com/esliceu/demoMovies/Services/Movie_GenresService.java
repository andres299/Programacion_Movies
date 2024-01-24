package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Repositorys.Movie_GenresRepo;
import com.esliceu.demoMovies.Repositorys.Movie_LanguagesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Movie_GenresService {
    @Autowired
    Movie_GenresRepo movieGenresRepo;
    public void deleteByGenreId(int entityId) {
        movieGenresRepo.deleteByGenreId(entityId);
    }

    public void deleteByMovieId(int movieId) { movieGenresRepo.deleteByMovieId(movieId); }
}
