package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CountryRepo extends JpaRepository<Country, Long> {
    @Query(value = "SELECT COUNT(*) FROM country WHERE country_id = ?1;", nativeQuery = true)
    long ifEntitiExist(int entityId);
}
