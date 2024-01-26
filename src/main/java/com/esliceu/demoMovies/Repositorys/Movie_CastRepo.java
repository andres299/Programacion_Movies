package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Movie_Cast;
import com.esliceu.demoMovies.Entities.Movie_Company;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface Movie_CastRepo  extends JpaRepository<Movie_Cast, Long> {

    @Query(value = "SELECT * FROM movie_cast WHERE movie_id = :movieId",nativeQuery = true)
    List<Movie_Cast> findCharacterNameByMovieId(int movieId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM movie_cast WHERE gender_id = :entityId", nativeQuery = true)
    void deleteByGenderId(int entityId);
    //List<Movie_Cast> findAllByGender_GenderId(int entityId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM movie_cast WHERE person_id = :entityId", nativeQuery = true)
    void deleteByPersonId(int entityId);
    //List<Movie_Cast> findAllByPerson_PersonId(int entityId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM movie_cast WHERE movie_id = :movieId", nativeQuery = true)
    void deleteByMovieId(int movieId);
    List<Movie_Cast> findAllByMovie_MovieId(int movieId);
}
