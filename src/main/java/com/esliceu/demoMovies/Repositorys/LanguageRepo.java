package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Language;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageRepo extends JpaRepository<Language, Long> {
    // Cuenta la cantidad de idiomas con un ID específico.
    int countLanguagesByLanguageId(int entityId);

    // Busca idiomas cuyos nombres comienzan con una palabra clave dada, admitiendo paginación.
    List<Language> findByLanguageNameStartingWithIgnoreCase(String keyword, Pageable pageable);
}
