package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CountryRepo extends JpaRepository<Country, Long> {
    @Query(value = "SELECT COUNT(*) > 0 AS entityExists FROM country WHERE country_id = :entityId;", nativeQuery = true)
    long ifEntitiExist(int entityId);
}
