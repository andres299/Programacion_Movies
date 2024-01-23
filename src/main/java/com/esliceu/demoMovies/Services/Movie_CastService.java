package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Repositorys.Movie_CastRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Movie_CastService {
    @Autowired
    Movie_CastRepo movieCastRepo;

    public void deleteByGenderId(int entityId) {
        movieCastRepo.deleteByGenderId(entityId);
    }

    public void deleteByPersonId(int entityId) {
        movieCastRepo.deleteByPersonId(entityId);
    }
}
