package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KeywordRepo extends JpaRepository<Keyword, Long> {
    @Query(value = "SELECT MAX(keyword_id) FROM keyword", nativeQuery = true)
    int getLastId();

    @Query(value = "SELECT COUNT(*) FROM keyword WHERE keyword_id = :entityId", nativeQuery = true)
    int ifEntitiExist(@Param("entityId") int entityId);

    List<Keyword> findByKeywordNameStartingWithIgnoreCase(String keyword);
}
