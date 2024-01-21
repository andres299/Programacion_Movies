package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GenreRepo extends JpaRepository<Genre, Long> {
    @Query(value = "SELECT MAX(genre_id) FROM genre", nativeQuery = true)
    int getLastId();

    @Query(value = "SELECT COUNT(*) FROM genre WHERE genre_id = :entityId", nativeQuery = true)
    int ifEntitiExist(@Param("entityId") int entityId);

}
