package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Production_Company;
import com.esliceu.demoMovies.Repositorys.Production_CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionCompanyService {
    @Autowired
    Production_CompanyRepo productionCompanyRepo;

    public List<?> findAll() {
        return productionCompanyRepo.findAll();
    }

    public Production_Company findFirstByOrderByCompanyIdDesc() {
        return productionCompanyRepo.findFirstByOrderByCompanyIdDesc();
    }
    public void save(Production_Company productionCompany) {
        productionCompanyRepo.save(productionCompany);
    }

    public void deleteById(long entityId) {
        productionCompanyRepo.deleteById(entityId);
    }

    public int countProductionCompaniesByCompanyId(int entityId) {
        return productionCompanyRepo.countProductionCompaniesByCompanyId(entityId);
    }

    public List<?> findByCompanyNameStartingWithIgnoreCase(String keyword) {
        return productionCompanyRepo.findByCompanyNameStartingWithIgnoreCase(keyword);
    }
}
