package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Country;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CountryRepo extends JpaRepository<Country, Long> {
    int countCountriesByCountryId(int entityId);

    List<Country> findByCountryNameStartingWithIgnoreCase(String keyword, Pageable pageable);
}
