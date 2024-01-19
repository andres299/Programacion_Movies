package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
}
