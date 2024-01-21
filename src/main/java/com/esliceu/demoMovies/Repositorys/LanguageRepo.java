package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Country;
import com.esliceu.demoMovies.Entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LanguageRepo extends JpaRepository<Language, Long> {
    @Query(value = "SELECT COUNT(*) > 0 AS entityExists FROM language WHERE language_id = :entityId;", nativeQuery = true)
    long ifEntitiExist(int entityId);
}
