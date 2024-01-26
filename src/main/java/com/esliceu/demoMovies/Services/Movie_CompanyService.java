package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Movie_Company;
import com.esliceu.demoMovies.Repositorys.Movie_CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Movie_CompanyService {
    @Autowired
    Movie_CompanyRepo movieCompanyRepo;

    public void deleteByProductionCompany(int entityId) {
        List<Movie_Company> allMovieCompany = movieCompanyRepo.findAllProductionComany_CompanyId(entityId);
        movieCompanyRepo.deleteAll(allMovieCompany);
    }

    public void deleteByMovieId(int movieId) { movieCompanyRepo.deleteByMovieId(movieId); }
}
