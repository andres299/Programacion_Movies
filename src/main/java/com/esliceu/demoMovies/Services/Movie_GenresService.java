package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Movie_Genres;
import com.esliceu.demoMovies.Repositorys.Movie_GenresRepo;
import com.esliceu.demoMovies.Repositorys.Movie_LanguagesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Movie_GenresService {
    @Autowired
    Movie_GenresRepo movieGenresRepo;


    public void deleteByMovieId(int movieId) { movieGenresRepo.deleteByMovieId(movieId); }

    public void deleteByGenreId(int entityId) {
        List<Movie_Genres> allGenres = movieGenresRepo.findAllByGenre_GenreId(entityId);
        movieGenresRepo.deleteAll(allGenres);
    }
}
