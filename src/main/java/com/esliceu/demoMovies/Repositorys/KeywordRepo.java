package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Keyword;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KeywordRepo extends JpaRepository<Keyword, Long> {

    Keyword findFirstByOrderByKeywordIdDesc();

    int countKeywordsByKeywordId(int entityId);

    List<Keyword> findByKeywordNameStartingWithIgnoreCase(String keyword, Pageable pageable);
}
