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

    public void save(Language_role languageRole) {
        language_roleRepo.save(languageRole);
    }

    public Language_role findFirstByOrderByRoleIdDesc() {
        return language_roleRepo.findFirstByOrderByRoleIdDesc();
    }

    public void deleteById(long entityId) {
        language_roleRepo.deleteById(entityId);
    }

    public int countLanguageRolesByRoleId(int entityId) {
        return language_roleRepo.countLanguageRolesByRoleId(entityId);
    }

    public List<?> findByLanguageRoleStartingWithIgnoreCase(String keyword) {
        return language_roleRepo.findByLanguageRoleStartingWithIgnoreCase(keyword);
    }
}
