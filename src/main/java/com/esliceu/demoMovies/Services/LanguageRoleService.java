package com.esliceu.demoMovies.Services;


import com.esliceu.demoMovies.Entities.Language_role;
import com.esliceu.demoMovies.Repositorys.Language_roleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageRoleService {
    @Autowired
    Language_roleRepo language_roleRepo;
    // Obtiene todos los roles de idioma paginados.
    public List<?> findAll(Pageable pageable) {
        return language_roleRepo.findAll(pageable).getContent();
    }
    // Guarda un nuevo rol de idioma.
    public void save(Language_role languageRole) {
        language_roleRepo.save(languageRole);
    }
    // Obtiene el primer rol de idioma ordenado por ID de forma descendente.
    public Language_role findFirstByOrderByRoleIdDesc() {
        return language_roleRepo.findFirstByOrderByRoleIdDesc();
    }
    // Elimina un rol de idioma por su ID.
    public void deleteById(long entityId) {
        language_roleRepo.deleteById(entityId);
    }
    // Cuenta la cantidad de roles de idioma con un ID específico.
    public int countLanguageRolesByRoleId(int entityId) {
        return language_roleRepo.countLanguageRolesByRoleId(entityId);
    }
    // Busca roles de idioma cuyos nombres comienzan con el término proporcionado.
    public List<?> findByLanguageRoleStartingWithIgnoreCase(String keyword, Pageable pageable) {
        return language_roleRepo.findByLanguageRoleStartingWithIgnoreCase(keyword,pageable);
    }
}
