package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Movie;
import com.esliceu.demoMovies.Entities.Movie_Cast;
import com.esliceu.demoMovies.Entities.Movie_Crew;
import com.esliceu.demoMovies.Entities.Person;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Movie_CrewRepo extends JpaRepository<Movie_Crew, Long> {
    // Elimina registros de Movie_Crew por ID de persona.
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM movie_crew WHERE person_id = :entityId", nativeQuery = true)
    void deleteByPersonId(int entityId);

    // Elimina registros de Movie_Crew por ID de departamento.
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM movie_crew WHERE department_id = :entityId", nativeQuery = true)
    void deleteByDepartmentId(int entityId);

    // Obtiene una lista de Movie_Crew por ID de película.
    List<Movie_Crew> findAllByMovie_MovieId(int movieId);

    void deleteByPersonAndMovie(Person person, Movie movie);
}
