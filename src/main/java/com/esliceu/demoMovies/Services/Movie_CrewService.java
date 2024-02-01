package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Department;
import com.esliceu.demoMovies.Entities.Movie;
import com.esliceu.demoMovies.Entities.Movie_Crew;
import com.esliceu.demoMovies.Entities.Person;
import com.esliceu.demoMovies.Repositorys.Movie_CrewRepo;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Movie_CrewService {
    @Autowired
    Movie_CrewRepo movieCrewRepo;

    // Elimina registros de Movie_Crew según el ID del departamento proporcionado.
    public void deleteByDepartmentId(int entityId) {
        movieCrewRepo.deleteByDepartmentId(entityId);
    }

    // Elimina registros de Movie_Crew según el ID de la persona proporcionado.
    public void deleteByPersonId(int entityId) {
        movieCrewRepo.deleteByPersonId(entityId);
    }

    // Elimina todos los registros de Movie_Crew asociados a una película específica según su ID.
    public void deleteByMovieId(int movieId) {
        List<Movie_Crew> allMovieCrew = movieCrewRepo.findAllByMovie_MovieId(movieId);
        movieCrewRepo.deleteAll(allMovieCrew);
    }

    // Guarda un nuevo registro de Movie_Crew representando al director de una película.
    public void save(Movie movie, Person person, Department department) {
        String job = "Director";
        Movie_Crew movieCrew = new Movie_Crew(movie, person, department, job);
        movieCrewRepo.save(movieCrew);
    }

    // Borrar por persona y la pelicula
    @Transactional
    public void deleteByPersonAndMovie(Person person, Movie movie) {
        movieCrewRepo.deleteByPersonAndMovie(person,movie);
    }
}
