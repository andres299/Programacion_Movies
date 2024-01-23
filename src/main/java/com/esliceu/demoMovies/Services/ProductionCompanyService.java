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

    public int getLastId() {
        return productionCompanyRepo.getLastId();
    }

    public void save(Production_Company productionCompany) {
        productionCompanyRepo.save(productionCompany);
    }

    public void deleteById(long entityId) {
        productionCompanyRepo.deleteById(entityId);
    }

    public int ifEntitiExist(int entityId) {
        return productionCompanyRepo.ifEntitiExist(entityId);
    }

    public List<?> findByCompanyNameStartingWithIgnoreCase(String keyword) {
        return productionCompanyRepo.findByCompanyNameStartingWithIgnoreCase(keyword);
    }
}
