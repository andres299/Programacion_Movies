package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Repositorys.Movie_CrewRepo;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Movie_CrewService {
    @Autowired
    Movie_CrewRepo movieCrewRepo;

    public void deleteByPersonId(int entityId) {
        movieCrewRepo.deleteByPersonId(entityId);
    }

    public void deleteByDepartmentId(int entityId) {
        movieCrewRepo.deleteByDepartmentId(entityId);
    }
}
