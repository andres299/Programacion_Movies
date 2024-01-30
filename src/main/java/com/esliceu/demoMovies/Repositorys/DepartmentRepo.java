package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Department;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
    // Cuenta la cantidad de departamentos con un ID específico.
    int countDepartmentsByDepartmentId(int entityId);
    // Busca departamentos cuyos nombres comienzan con una palabra clave dada, admitiendo paginación.
    List<Department> findByDepartmentNameStartingWithIgnoreCase(String keyword, Pageable pageable);
}
