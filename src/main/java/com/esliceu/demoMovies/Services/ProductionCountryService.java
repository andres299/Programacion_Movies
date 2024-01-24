package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Repositorys.Production_CompanyRepo;
import com.esliceu.demoMovies.Repositorys.Production_CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductionCountryService {
    @Autowired
    Production_CountryRepo productionCountryRepo;
    public void deleteByCountryId(int entityId) {
        productionCountryRepo.deleteByCountryId(entityId);
    }

    public void deleteByMovieId(int movieId) { productionCountryRepo.deleteByMovieId(movieId); }
}
