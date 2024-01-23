package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Repositorys.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    @Autowired
    GenreRepo genreRepo;

    public List<?> findAll() {
        return genreRepo.findAll();
    }
}
