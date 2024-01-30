package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Production_Company;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Production_CompanyRepo extends JpaRepository<Production_Company, Long> {
    // Obtiene el primer registro de Production_Company ordenado por ID de forma descendente.
    Production_Company findFirstByOrderByCompanyIdDesc();
    // Cuenta la cantidad de compañías de producción que tienen un ID específico.
    int countProductionCompaniesByCompanyId(int entityId);
    // Obtiene una lista de Production_Company cuyos nombres comienzan con una palabra clave dada, admitiendo paginación.
    List<Production_Company> findByCompanyNameStartingWithIgnoreCase(String keyword, Pageable pageable);
}
