package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Production_Company;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Production_CompanyRepo extends JpaRepository<Production_Company, Long> {
    Production_Company findFirstByOrderByCompanyIdDesc();

    int countProductionCompaniesByCompanyId(int entityId);

    List<Production_Company> findByCompanyNameStartingWithIgnoreCase(String keyword, Pageable pageable);
}
