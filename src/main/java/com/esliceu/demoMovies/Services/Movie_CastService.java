package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.DTO.FetchInfoMoviesDTO;
import com.esliceu.demoMovies.Entities.*;
import com.esliceu.demoMovies.Repositorys.Movie_CastRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Movie_CastService {
    @Autowired
    Movie_CastRepo movieCastRepo;

    // Elimina registros de Movie_Cast según el ID de género proporcionado.
    public void deleteByGenderId(int entityId) {
        movieCastRepo.deleteByGenderId(entityId);
    }
    // Elimina registros de Movie_Cast según el ID de persona proporcionado.
    public void deleteByPersonId(int entityId) {
        movieCastRepo.deleteByPersonId(entityId);
    }
    // Elimina todos los registros de Movie_Cast asociados a una película específica según su ID.
    public void deleteByMovieId(int movieId) {
        List<Movie_Cast> allMovieCast = movieCastRepo.findAllByMovie_MovieId(movieId);
        movieCastRepo.deleteAll(allMovieCast);
    }
    // Obtiene todos los registros de Movie_Cast en la base de datos.
    public List<Movie_Cast> findAll() {
        return movieCastRepo.findAll();
    }
    // Obtiene los nombres de los personajes (characterName) en Movie_Cast asociados a una película específica según su ID.
    public List<Movie_Cast> findCharacterNameByMovieId(int movieId) {
        return movieCastRepo.findCharacterNameByMovieId(movieId);
    }
    // Guarda un nuevo registro de Movie_Cast en la base de datos.
    public void save(Movie movie, Person person, String input2, Gender genreEntiti, int cast_Order) {
        Movie_Cast movieCast = new Movie_Cast(movie,person,input2,genreEntiti,cast_Order);
        movieCastRepo.save(movieCast);
    }
    // Borra el cast de movie por la persona y la pelicula
    @Transactional
    public void deleteByPersonAndMovie(Person person, Movie movie) {
        movieCastRepo.deleteByPersonAndMovie(person,movie);
    }
    // Encuentra el ultimo castOrder de una pelicula especifica
    public Movie_Cast findFirstByMovie_MovieIdOrderByCastOrderDesc(int movieId) {
        return movieCastRepo.findFirstByMovie_MovieIdOrderByCastOrderDesc(movieId);
    }

    // Comprobar si el personaje ya existe
    public long countMovieCastsByCharacterNameAndMovie_MovieId(String input2, int movieId) {
        return movieCastRepo.countMovieCastsByCharacterNameAndMovie_MovieId(input2,movieId);
    }
}
