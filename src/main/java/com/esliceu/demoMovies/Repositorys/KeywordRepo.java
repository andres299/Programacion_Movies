package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Keyword;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KeywordRepo extends JpaRepository<Keyword, Long> {

    // Obtiene el primer registro de palabra clave ordenado por el ID de manera descendente.
    Keyword findFirstByOrderByKeywordIdDesc();
    // Cuenta la cantidad de palabras clave con un ID específico.
    int countKeywordsByKeywordId(int entityId);
    // Busca palabras clave cuyos nombres comienzan con una palabra clave dada, admitiendo paginación.
    List<Keyword> findByKeywordNameStartingWithIgnoreCase(String keyword, Pageable pageable);
}
