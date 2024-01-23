package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Genre;
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

    public int getLastId() {
        return genreRepo.getLastId();
    }

    public void deleteById(long entityId) {
        genreRepo.deleteById(entityId);
    }

    public void save(Genre genre) {
        genreRepo.save(genre);
    }

    public int ifEntitiExist(int entityId) {
        return genreRepo.ifEntitiExist(entityId);
    }
}
