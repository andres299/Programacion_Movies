package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Movie_Crew;
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
    }
}
