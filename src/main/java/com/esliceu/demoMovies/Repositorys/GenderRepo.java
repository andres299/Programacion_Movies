package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Gender;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenderRepo extends JpaRepository<Gender, Long> {
    // Obtiene el primer registro de género ordenado por el ID de manera descendente.
    Gender findFirstByOrderByGenderIdDesc();
    // Cuenta la cantidad de géneros con un ID específico.
    int countGendersByGenderId(int entityId);
    // Busca géneros cuyos nombres comienzan con una palabra clave dada, admitiendo paginación.
    List<Gender> findByGenderStartingWithIgnoreCase(String keyword, Pageable pageable);
    // Busca un género por su ID.
    Gender findByGenderId(int genre);
}
