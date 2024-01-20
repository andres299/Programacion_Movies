package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Language_role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Language_roleRepo extends JpaRepository<Language_role, Long> {
    @Query(value = "SELECT MAX(role_id) FROM language_role", nativeQuery = true)
    int getLastId();
}
