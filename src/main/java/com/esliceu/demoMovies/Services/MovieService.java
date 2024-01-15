package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Movie;
import com.esliceu.demoMovies.Repositorys.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepo movieRepo;
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    public List<Movie> filterMovies(String filterType ,String keyword) {
        System.out.println("filterMovies llamado con palabra clave: " + keyword + " y tipo de filtro: " + filterType);
        if ("title".equals(filterType)) {
            return movieRepo.findByTitle(keyword);
        } else if () {
            
        }
        return Collections.emptyList();

    }
}
