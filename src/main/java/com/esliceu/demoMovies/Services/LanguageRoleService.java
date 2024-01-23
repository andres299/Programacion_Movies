package com.esliceu.demoMovies.Services;


import com.esliceu.demoMovies.Entities.Language_role;
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

    public int getLastId() {
        return language_roleRepo.getLastId();
    }

    public void save(Language_role languageRole) {
        language_roleRepo.save(languageRole);
    }
}
