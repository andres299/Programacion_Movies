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

    public void deleteByPersonId(int entityId) {
        List<Movie_Crew> allMovieCrew = movieCrewRepo.findAllByDepartment_DepartmentId(entityId);
        movieCrewRepo.deleteAll(allMovieCrew);
    }

    public void deleteByDepartmentId(int entityId) { movieCrewRepo.deleteByDepartmentId(entityId); }

    public void deleteByMovieId(int movieId) { movieCrewRepo.deleteByMovieId(movieId); }
}
