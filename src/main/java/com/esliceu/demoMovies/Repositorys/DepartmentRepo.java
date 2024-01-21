package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
    @Query(value = "SELECT MAX(department_id) FROM department", nativeQuery = true)
    int getLastId();

    @Query(value = "SELECT COUNT(*) > 0 AS entityExists FROM department WHERE department_id = :entityId;", nativeQuery = true)
    long ifEntitiExist(int entityId);
}
