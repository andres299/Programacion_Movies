package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface CountryRepo extends JpaRepository<Country, Long> {
    int countCountriesByCountryId(int entityId);

    List<Country> findByCountryNameStartingWithIgnoreCase(String keyword);
}
