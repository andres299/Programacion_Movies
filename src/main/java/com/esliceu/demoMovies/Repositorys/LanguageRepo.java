package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Language;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageRepo extends JpaRepository<Language, Long> {
    int countLanguagesByLanguageId(int entityId);

    List<Language> findByLanguageNameStartingWithIgnoreCase(String keyword, Pageable pageable);
}
