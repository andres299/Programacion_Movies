package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Production_Company;
import com.esliceu.demoMovies.Entities.Production_Country;
import com.esliceu.demoMovies.Services.ProductionCountryService;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Production_CountryRepo extends JpaRepository<Production_Country, Long> {
    // Obtiene una lista de Production_Country por ID de país.
    List<Production_Country> findAllByCountry_CountryId(int entityId);

    // Obtiene una lista de Production_Country por ID de película.
    List<Production_Country> findAllByMovie_MovieId(int movieId);
}
