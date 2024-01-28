package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Language;
import com.esliceu.demoMovies.Repositorys.LanguageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {
    @Autowired
    LanguageRepo languageRepo;

    // Obtiene todos los idiomas paginados.
    public List<?> findAll(Pageable pageable) { return languageRepo.findAll(pageable).getContent(); }

    // Guarda un nuevo idioma.
    public void save(Language language) { languageRepo.save(language); }

    // Elimina un idioma por su ID.
    public void deleteById(long entityId) { languageRepo.deleteById(entityId); }

    // Cuenta la cantidad de idiomas con un ID específico.
    public int countLanguagesByLanguageId(int entityId) { return languageRepo.countLanguagesByLanguageId(entityId); }

    // Busca idiomas cuyos nombres comienzan con el keyword proporcionado.
    public List<?> findByLanguageNameStartingWithIgnoreCase(String keyword, Pageable pageable) {
        return languageRepo.findByLanguageNameStartingWithIgnoreCase(keyword, pageable);
    }
}

