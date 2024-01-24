package com.esliceu.demoMovies.Services;


import com.esliceu.demoMovies.Repositorys.Movie_KeywordsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Movie_KeywordsService {
    @Autowired
    Movie_KeywordsRepo movieKeywordsRepo;

    public void deleteByKeywordId(int entityId) {
        movieKeywordsRepo.deleteByKeywordId(entityId);
    }

    public void deleteByMovieId(int movieId) { movieKeywordsRepo.deleteByMovieId(movieId);}
}
