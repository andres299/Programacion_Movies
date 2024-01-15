package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Movie;
import com.esliceu.demoMovies.Repositorys.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepo movieRepo;
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }
}
