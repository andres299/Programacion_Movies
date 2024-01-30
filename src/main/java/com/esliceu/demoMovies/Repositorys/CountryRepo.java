package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Country;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CountryRepo extends JpaRepository<Country, Long> {
    // Método para contar la cantidad de países con un ID específico.
    int countCountriesByCountryId(int entityId);

    // Método para buscar países cuyos nombres comienzan con la palabra clave dada, admitiendo paginación.
    List<Country> findByCountryNameStartingWithIgnoreCase(String keyword, Pageable pageable);
}
