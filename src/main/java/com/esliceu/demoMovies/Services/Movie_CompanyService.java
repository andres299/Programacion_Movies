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

    // Elimina registros de Movie_Company según el ID de la compañía de producción proporcionado.
    public void deleteByProductionCompany(int entityId) {
        movieCompanyRepo.deleteByCompanyId(entityId);
    }

    // Elimina todos los registros de Movie_Company asociados a una película específica según su ID.
    public void deleteByMovieId(int movieId) {
        movieCompanyRepo.deleteByMovieId(movieId);
    }
}
