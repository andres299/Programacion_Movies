package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Repositorys.Movie_CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Movie_CompanyService {
    @Autowired
    Movie_CompanyRepo movieCompanyRepo;

    public void deleteByProductionCompany(int entityId) {
        movieCompanyRepo.deleteByProductionCompany(entityId);
    }
}
