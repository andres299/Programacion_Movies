package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GenreRepo extends JpaRepository<Genre, Long> {
    @Query(value = "SELECT MAX(genre_id) FROM genre", nativeQuery = true)
    int getLastId();

    @Query(value = "SELECT COUNT(*) FROM genre WHERE genre_id = ?1;", nativeQuery = true)
    long ifEntitiExist(int entityId);
}
