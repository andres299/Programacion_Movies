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
        //List<Movie_Company> allMovieCompany = movieCompanyRepo.findAllByProductionCompany_CompanyId(entityId);
        //movieCompanyRepo.deleteAll(allMovieCompany);
        movieCompanyRepo.deleteByCompanyId(entityId);
    }

    public void deleteByMovieId(int movieId) {
        //List<Movie_Company> allMovieCompany = movieCompanyRepo.findAllByProductionMovie_MovieId(movieId);
        //movieCompanyRepo.deleteAll(allMovieCompany);
        movieCompanyRepo.deleteByMovieId(movieId);
    }
}
