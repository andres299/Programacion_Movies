package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
    @Query(value = "SELECT COUNT(*) FROM department WHERE department_id = :entityId", nativeQuery = true)
    int ifEntitiExist(@Param("entityId") int entityId);

    List<Department> findByDepartmentNameStartingWithIgnoreCase(String keyword);
}
