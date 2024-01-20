package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KeywordRepo extends JpaRepository<Keyword, Long> {
    @Query(value = "SELECT MAX(keyword_id) FROM keyword", nativeQuery = true)
    int getLastId();
}
