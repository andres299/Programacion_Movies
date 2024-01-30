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
    // Obtiene todas las entidades Department paginadas
    public List<?> findAll(Pageable pageable) {
        return departmentRepo.findAll(pageable).getContent();
    }
    // Guarda un nuevo departamento.
    public void save(Department department) {
        departmentRepo.save(department);
    }
    // Elimina un departamento por su ID.
    public void deleteById(long entityId) {
        departmentRepo.deleteById(entityId);
    }
    // Cuenta la cantidad de departamentos con un ID específico.
    public int countDepartmentsByDepartmentId(int entityId) {
        return departmentRepo.countDepartmentsByDepartmentId(entityId);
    }
    // Busca departamentos cuyos nombres comienzan con la palabra clave proporcionada.
    public List<?> findByDepartmentNameStartingWithIgnoreCase(String keyword, Pageable pageable) {
        return departmentRepo.findByDepartmentNameStartingWithIgnoreCase(keyword,pageable);
    }
    // Obtiene un departamento por su ID.
    public Department findById(int departmentId) {
        return departmentRepo.findById(Long.valueOf(departmentId)).orElseThrow();
    }
}
