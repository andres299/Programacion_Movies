package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Department;
import com.esliceu.demoMovies.Repositorys.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepo departmentRepo;

    public List<?> findAll(Pageable pageable) {
        return departmentRepo.findAll(pageable).getContent();
    }

    public void save(Department department) {
        departmentRepo.save(department);
    }

    public void deleteById(long entityId) {
        departmentRepo.deleteById(entityId);
    }

    public int countDepartmentsByDepartmentId(int entityId) {
        return departmentRepo.countDepartmentsByDepartmentId(entityId);
    }

    public List<?> findByDepartmentNameStartingWithIgnoreCase(String keyword, Pageable pageable) {
        return departmentRepo.findByDepartmentNameStartingWithIgnoreCase(keyword,pageable);
    }
}
