package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Genre;
import com.esliceu.demoMovies.Entities.Movie;
import com.esliceu.demoMovies.Entities.Movie_Crew;
import com.esliceu.demoMovies.Entities.Movie_Genres;
import com.esliceu.demoMovies.Repositorys.Movie_GenresRepo;
import com.esliceu.demoMovies.Repositorys.Movie_LanguagesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Movie_GenresService {
    @Autowired
    Movie_GenresRepo movieGenresRepo;

    // Elimina registros de Movie_Genres asociados a una película.
    public void deleteByMovieId(int movieId) {
        List<Movie_Genres> allGenres = movieGenresRepo.findAllByMovie_MovieId(movieId);
        movieGenresRepo.deleteAll(allGenres);
    }
    // Elimina registros de Movie_Genres asociados a un género.
    public void deleteByGenreId(int entityId) {
        List<Movie_Genres> allGenres = movieGenresRepo.findAllByGenre_GenreId(entityId);
        movieGenresRepo.deleteAll(allGenres);
    }
    // Guarda una nueva relación entre película y género en Movie_Genres.
    public void save(Movie movie, Genre newGenre) {
        Movie_Genres movieGenres = new Movie_Genres(movie,newGenre);
        movieGenresRepo.save(movieGenres);
    }
    //Borro el gernro de la pelicula
    @Transactional
    public void deleteByGenreAndMovie(Genre genreDelte, Movie movie) {
        movieGenresRepo.deleteByGenreAndMovie(genreDelte,movie);
    }
}
