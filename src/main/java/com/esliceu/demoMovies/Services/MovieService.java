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

    public List<Movie> filterMovies(String keyword, String filterType) {
        // Lógica para filtrar películas según filterType y keyword
        //if ("actor".equals(filterType)) {
          //  return movieRepo.findByActor(keyword);
        //} else if ("characters".equals(filterType)) {
          //  return movieRepo.findByCharacter(keyword);
        //} else
            if ("title".equals(filterType)) {
            return movieRepo.findByTitle(keyword);
        //} else if ("genre".equals(filterType)) {
          //  return movieRepo.findByGenre(keyword);
        //} else if ("director".equals(filterType)) {
          //  return movieRepo.findByDirector(keyword);
        }
        return null;
    }
}
