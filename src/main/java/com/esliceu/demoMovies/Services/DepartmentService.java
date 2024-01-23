package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Repositorys.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepo departmentRepo;

    public List<?> findAll() {
        return departmentRepo.findAll();
    }
}
