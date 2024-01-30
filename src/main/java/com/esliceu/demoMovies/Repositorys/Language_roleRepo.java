package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Language_role;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Language_roleRepo extends JpaRepository<Language_role, Long> {

    // Cuenta la cantidad de roles de lenguaje con un ID específico.
    int countLanguageRolesByRoleId(int entityId);
    // Busca roles de lenguaje cuyos nombres comienzan con una palabra clave dada, admitiendo paginación.
    List<Language_role> findByLanguageRoleStartingWithIgnoreCase(String keyword, Pageable pageable);
    // Obtiene el primer registro de rol de lenguaje ordenado por el ID de manera descendente.
    Language_role findFirstByOrderByRoleIdDesc();
}
