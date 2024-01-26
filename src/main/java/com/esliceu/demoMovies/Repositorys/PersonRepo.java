package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepo extends JpaRepository<Person, Long> {
    Person findFirstByOrderByPersonIdDesc();

    @Query(value = "SELECT COUNT(*) FROM person WHERE person_id = :entityId", nativeQuery = true)
    int ifEntitiExist(@Param("entityId") int entityId);

    List<Person> findByPersonNameStartingWithIgnoreCase(String keyword);

    List<Person> findPersonByMoviecast_MovieMovieIdEquals(int movieId);

    List<Person> findDistincPersonByMovieCrewsJobAndMovieCrews_MovieMovieIdEquals(String director,int movieId);
}
