package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Administrator;
import com.esliceu.demoMovies.Entities.Movie_Languages;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Movie_LanguagesRepo extends JpaRepository<Movie_Languages, Long> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM movie_languages WHERE language_id = :entityId", nativeQuery = true)
    void deleteByLanguageId(@Param("entityId") int entityId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM movie_languages WHERE language_role_id = :entityId", nativeQuery = true)
    void deleteByLanguageRoleId(@Param("entityId")int entityId);
}
