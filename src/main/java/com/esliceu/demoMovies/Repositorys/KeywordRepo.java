package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KeywordRepo extends JpaRepository<Keyword, Long> {

    Keyword findFirstByOrderByKeywordIdDesc();

    int countKeywordsByKeywordId(int entityId);

    List<Keyword> findByKeywordNameStartingWithIgnoreCase(String keyword);
}
