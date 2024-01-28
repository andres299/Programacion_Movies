package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Administrator;
import com.esliceu.demoMovies.Repositorys.LoginAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    LoginAdminRepo loginAdminRepo;

    // Verifica la existencia de un administrador
    public boolean adminExists(String username, String password) {
        Administrator administrator = loginAdminRepo.findByUsernameAndPassword(username, password);
        return administrator != null;
    }
    // Obtiene información del administrador
    public Object admin(String username) {
        return loginAdminRepo.findByUsername(username);
    }
}
