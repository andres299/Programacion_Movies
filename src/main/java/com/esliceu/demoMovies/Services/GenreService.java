package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Repositorys.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {
    @Autowired
    GenreRepo genreRepo;
}
