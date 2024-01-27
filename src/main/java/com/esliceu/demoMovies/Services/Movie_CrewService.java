package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Department;
import com.esliceu.demoMovies.Entities.Movie;
import com.esliceu.demoMovies.Entities.Movie_Crew;
import com.esliceu.demoMovies.Entities.Person;
import com.esliceu.demoMovies.Repositorys.Movie_CrewRepo;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Movie_CrewService {
    @Autowired
    Movie_CrewRepo movieCrewRepo;

    public void deleteByDepartmentId(int entityId) {
        //List<Movie_Crew> allMovieCrew = movieCrewRepo.findAllByDepartment_DepartmentId(entityId);
        //movieCrewRepo.deleteAll(allMovieCrew);
        movieCrewRepo.deleteByDepartmentId(entityId);
    }

    public void deleteByPersonId(int entityId) {
        //List<Movie_Crew> allMovieCrew = movieCrewRepo.findAllByPerson_PersonId(entityId);
        //movieCrewRepo.deleteAll(allMovieCrew);
        movieCrewRepo.deleteByPersonId(entityId);
    }

    public void deleteByMovieId(int movieId) {
        List<Movie_Crew> allMovieCrew = movieCrewRepo.findAllByMovie_MovieId(movieId);
        movieCrewRepo.deleteAll(allMovieCrew);
        //movieCrewRepo.deleteByMovieId(movieId);
    }

    public void save(Movie movie, Person person, Department department) {
        String job = "Director";
        Movie_Crew movieCrew = new Movie_Crew(movie,person,department,job);
        movieCrewRepo.save(movieCrew);
    }
}
