package com.esliceu.demoMovies.Services;


import com.esliceu.demoMovies.Entities.Movie_Keywords;
import com.esliceu.demoMovies.Repositorys.Movie_KeywordsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Movie_KeywordsService {
    @Autowired
    Movie_KeywordsRepo movieKeywordsRepo;

    public void deleteByKeywordId(int entityId) {
        List<Movie_Keywords> allKeywords = movieKeywordsRepo.findAllByKeyword_KeywordId(entityId);
        movieKeywordsRepo.deleteAll(allKeywords);
    }

    public void deleteByMovieId(int movieId) {
        List<Movie_Keywords> allKeywords = movieKeywordsRepo.findAllByMovie_MovieId(movieId);
        movieKeywordsRepo.deleteAll(allKeywords);
        movieKeywordsRepo.deleteByMovieId(movieId);
    }
}
