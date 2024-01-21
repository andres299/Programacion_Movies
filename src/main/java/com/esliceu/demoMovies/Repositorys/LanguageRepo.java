package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Country;
import com.esliceu.demoMovies.Entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LanguageRepo extends JpaRepository<Language, Long> {
    @Query(value = "SELECT COUNT(*) FROM language WHERE language_id = ?1;", nativeQuery = true)
    long ifEntitiExist(int entityId);
}
