package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
    int countDepartmentsByDepartmentId(int entityId);

    List<Department> findByDepartmentNameStartingWithIgnoreCase(String keyword);
}
