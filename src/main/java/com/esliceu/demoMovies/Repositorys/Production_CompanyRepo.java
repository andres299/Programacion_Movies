package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Production_Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Production_CompanyRepo extends JpaRepository<Production_Company, Long> {
    @Query(value = "SELECT MAX(company_id) FROM production_company", nativeQuery = true)
    int getLastId();

    @Query(value = "SELECT COUNT(*) > 0 AS entityExists FROM production_company WHERE company_id = :entityId;", nativeQuery = true)
    boolean ifEntitiExist(int entityId);
}
