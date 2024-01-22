package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Production_Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Production_CompanyRepo extends JpaRepository<Production_Company, Long> {
    @Query(value = "SELECT MAX(company_id) FROM production_company", nativeQuery = true)
    int getLastId();

    @Query(value = "SELECT COUNT(*) FROM production_company WHERE company_id = :entityId", nativeQuery = true)
    int ifEntitiExist(@Param("entityId") int entityId);

    List<Production_Company> findByCompanyNameStartingWithIgnoreCase(String keyword);
}
