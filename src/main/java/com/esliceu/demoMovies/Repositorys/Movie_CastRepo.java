package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Movie_Cast;
import com.esliceu.demoMovies.Entities.Movie_Company;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Movie_CastRepo  extends JpaRepository<Movie_Cast, Long> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM movie_cast WHERE gender_id = :entityId", nativeQuery = true)
    void deleteByGenderId(@Param("entityId") int entityId);
}
