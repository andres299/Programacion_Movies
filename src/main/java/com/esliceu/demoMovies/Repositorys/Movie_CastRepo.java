package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Movie;
import com.esliceu.demoMovies.Entities.Movie_Cast;
import com.esliceu.demoMovies.Entities.Movie_Company;
import com.esliceu.demoMovies.Entities.Person;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface Movie_CastRepo  extends JpaRepository<Movie_Cast, Long> {

    // Consulta que busca los nombres de personajes por ID de película.
    @Query(value = "SELECT * FROM movie_cast WHERE movie_id = :movieId",nativeQuery = true)
    List<Movie_Cast> findCharacterNameByMovieId(int movieId);
    // Elimina registros de Movie_Cast por ID de género.
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM movie_cast WHERE gender_id = :entityId", nativeQuery = true)
    void deleteByGenderId(int entityId);
    // Elimina registros de Movie_Cast por ID de persona.
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM movie_cast WHERE person_id = :entityId", nativeQuery = true)
    void deleteByPersonId(int entityId);
    // Busca todos los registros de Movie_Cast por ID de película.
    List<Movie_Cast> findAllByMovie_MovieId(int movieId);

    //List<Movie_Cast> findByPerson(Person person);

    Movie_Cast findByPersonAndMovie(Person person, Movie movie);
}
