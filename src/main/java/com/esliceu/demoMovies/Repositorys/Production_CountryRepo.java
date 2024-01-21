package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Production_Company;
import com.esliceu.demoMovies.Entities.Production_Country;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Production_CountryRepo extends JpaRepository<Production_Country, Long> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM production_country WHERE country_id = :entityId", nativeQuery = true)
    void deleteByCountryId(@Param("entityId") int entityId);
    
}
