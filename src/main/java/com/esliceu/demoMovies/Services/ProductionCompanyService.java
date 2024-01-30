package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Production_Company;
import com.esliceu.demoMovies.Repositorys.Production_CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionCompanyService {
    @Autowired
    Production_CompanyRepo productionCompanyRepo;
    // Devuelve todos los registros de Production_Company paginados.
    public List<?> findAll(Pageable pageable) {
        return productionCompanyRepo.findAll(pageable).getContent();
    }
    // Devuelve el primer registro de Production_Company ordenado por el ID de la compañía de
    // producción de forma descendente.
    public Production_Company findFirstByOrderByCompanyIdDesc() {
        return productionCompanyRepo.findFirstByOrderByCompanyIdDesc();
    }
    // Guarda un nuevo registro de Production_Company en la base de datos.
    public void save(Production_Company productionCompany) {
        productionCompanyRepo.save(productionCompany);
    }
    // Elimina un registro de Production_Company por su ID.
    public void deleteById(long entityId) {
        productionCompanyRepo.deleteById(entityId);
    }
    // Cuenta la cantidad de compañías de producción que tienen un ID específico.
    public int countProductionCompaniesByCompanyId(int entityId) {
        return productionCompanyRepo.countProductionCompaniesByCompanyId(entityId);
    }
    // Devuelve las compañías de producción cuyos nombres comienzan con una palabra clave específica.
    public List<?> findByCompanyNameStartingWithIgnoreCase(String keyword, Pageable pageable) {
        return productionCompanyRepo.findByCompanyNameStartingWithIgnoreCase(keyword,pageable);
    }
}
