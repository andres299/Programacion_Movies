package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Language_role;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Language_roleRepo extends JpaRepository<Language_role, Long> {

    int countLanguageRolesByRoleId(int entityId);

    List<Language_role> findByLanguageRoleStartingWithIgnoreCase(String keyword, Pageable pageable);

    Language_role findFirstByOrderByRoleIdDesc();
}
