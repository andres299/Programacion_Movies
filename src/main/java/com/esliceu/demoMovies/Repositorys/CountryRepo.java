package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface CountryRepo extends JpaRepository<Country, Long> {
    @Query(value = "SELECT COUNT(*) FROM country WHERE country_id = :entityId", nativeQuery = true)
    int ifEntitiExist(@Param("entityId") int entityId);

    List<Country> findByCountryNameStartingWithIgnoreCase(String input1);
}
