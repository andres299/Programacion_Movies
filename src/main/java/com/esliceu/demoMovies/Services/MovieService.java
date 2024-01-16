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

    public List<Movie> getFirstMovies() {
        List<Movie> firstMovies = movieRepo.findAll();
        return firstMovies.subList(0,10);
    }

    public List<Movie> getAllMoviesByPage(int page) {
        List<Movie> allMovies = movieRepo.findAll();
        int pageSize = 10;
        int start = Math.toIntExact(page * pageSize);
        int end = Math.toIntExact(Math.min((page + 1) * pageSize, allMovies.size()));
        return allMovies.subList(start,end);
    }
    public List<Movie> filterMovies(String filterType ,String keyword) {
        System.out.println("filterMovies llamado con palabra clave: " + keyword + " y tipo de filtro: " + filterType);
        if ("title".equals(filterType)) {
            return movieRepo.findByTitleContaining(keyword);
        } else if ("actor".equals(filterType)) {
            return movieRepo.findByMoviecast_Person_person_nameContaining(keyword);
        } else if ("characters".equals(filterType)){
            return movieRepo.findByCharacterNameContaining(keyword);
        } else if ("genre".equals(filterType)) {
            return movieRepo.findByGenreNameContaining(keyword);
        } else if ("director".equals(filterType)) {
            return movieRepo.findByDirectorNameContaining(keyword);
        }
        return Collections.emptyList();

    }
}
