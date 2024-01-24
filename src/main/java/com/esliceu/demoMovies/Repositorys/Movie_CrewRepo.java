package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Movie_Cast;
import com.esliceu.demoMovies.Entities.Movie_Crew;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Movie_CrewRepo extends JpaRepository<Movie_Crew, Long> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM movie_crew WHERE person_id = :entityId", nativeQuery = true)
    void deleteByPersonId(@Param("entityId") int entityId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM movie_crew WHERE department_id = :entityId", nativeQuery = true)
    void deleteByDepartmentId(@Param("entityId") int entityId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM movie_crew WHERE movie_id = :movieId", nativeQuery = true)
    void deleteByMovieId(int movieId);

}
