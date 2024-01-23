package com.esliceu.demoMovies.Services;


import com.esliceu.demoMovies.Repositorys.Language_roleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageRoleService {
    @Autowired
    Language_roleRepo language_roleRepo;

    public List<?> findAll() {
        return language_roleRepo.findAll();
    }
}
