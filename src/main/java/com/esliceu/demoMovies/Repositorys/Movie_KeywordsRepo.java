package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Keyword;
import com.esliceu.demoMovies.Entities.Movie_Keywords;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Movie_KeywordsRepo extends JpaRepository<Movie_Keywords, Long> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM movie_keywords WHERE keyword_id = :entityId", nativeQuery = true)
    void deleteByKeywordId(@Param("entityId") int entityId);
}
