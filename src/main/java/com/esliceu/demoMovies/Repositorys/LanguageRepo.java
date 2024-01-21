package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Country;
import com.esliceu.demoMovies.Entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LanguageRepo extends JpaRepository<Language, Long> {
    @Query(value = "SELECT COUNT(*) FROM language WHERE language_id = :entityId", nativeQuery = true)
    int ifEntitiExist(@Param("entityId") int entityId);
}
