package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Department;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
    int countDepartmentsByDepartmentId(int entityId);

    List<Department> findByDepartmentNameStartingWithIgnoreCase(String keyword, Pageable pageable);
}
