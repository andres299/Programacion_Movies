package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Movie;
import com.esliceu.demoMovies.Entities.Movie_Cast;
import com.esliceu.demoMovies.Repositorys.Movie_CastRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class Movie_CastService {
    @Autowired
    Movie_CastRepo movieCastRepo;

    public void deleteByGenderId(int entityId) {
        List<Movie_Cast> allMovieCast = movieCastRepo.findAllGender_GenderId(entityId);
        movieCastRepo.deleteAll(allMovieCast);
    }

    public void deleteByPersonId(int entityId) {
        movieCastRepo.deleteByPersonId(entityId);
    }

    public void deleteByMovieId(int movieId) { movieCastRepo.deleteByMovieId(movieId); }

    public List<Movie_Cast> findAll() {
        return movieCastRepo.findAll();
    }

    public List<Movie_Cast> findCharacterNameByMovieId(int movieId) {
        return movieCastRepo.findCharacterNameByMovieId(movieId);
    }
}
