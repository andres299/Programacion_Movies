package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KeywordRepo extends JpaRepository<Keyword, Long> {
    @Query(value = "SELECT MAX(keyword_id) FROM keyword", nativeQuery = true)
    int getLastId();


    @Query(value = "SELECT COUNT(*) > 0 AS entityExists FROM keyword WHERE keyword_id = :entityId;", nativeQuery = true)
    boolean ifEntitiExist(int entityId);
}
