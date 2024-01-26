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

    public List<?> findAll(Pageable pageable) {
        return languageRepo.findAll(pageable).getContent();
    }

    public void save(Language language) {
        languageRepo.save(language);
    }

    public void deleteById(long entityId) {
        languageRepo.deleteById(entityId);
    }

    public int countLanguagesByLanguageId(int entityId) {
        return languageRepo.countLanguagesByLanguageId(entityId);
    }

    public List<?> findByLanguageNameStartingWithIgnoreCase(String keyword, Pageable pageable) {
        return languageRepo.findByLanguageNameStartingWithIgnoreCase(keyword,pageable);
    }
}
