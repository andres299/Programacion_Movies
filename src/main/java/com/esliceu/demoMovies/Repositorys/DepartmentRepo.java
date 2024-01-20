package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
    @Query(value = "SELECT MAX(department_id) FROM department", nativeQuery = true)
    int getLastId();
}
