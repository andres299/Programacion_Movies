package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Production_Country;
import com.esliceu.demoMovies.Repositorys.Production_CompanyRepo;
import com.esliceu.demoMovies.Repositorys.Production_CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionCountryService {
    @Autowired
    Production_CountryRepo productionCountryRepo;

    // Eliminar todas las entradas de Production_Country asociadas con el ID del país proporcionado.
    public void deleteByCountryId(int entityId) {
        List<Production_Country> allProductionCountry =
                productionCountryRepo.findAllByCountry_CountryId(entityId);
        productionCountryRepo.deleteAll(allProductionCountry);
    }

    // Elimina todas las entradas de Production_Country asociadas con el ID de la película proporcionado.
    public void deleteByMovieId(int movieId) {
        List<Production_Country> allProductionCountry =
                productionCountryRepo.findAllByMovie_MovieId(movieId);
        productionCountryRepo.deleteAll(allProductionCountry);
    }
}
