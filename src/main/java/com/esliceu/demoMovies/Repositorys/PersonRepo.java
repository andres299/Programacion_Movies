package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Person;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepo extends JpaRepository<Person, Long> {
    Person findFirstByOrderByPersonIdDesc();

    int countPersonsByPersonId(int entityId);

    List<Person> findByPersonNameStartingWithIgnoreCase(String keyword, Pageable pageable);

    List<Person> findPersonByMoviecast_MovieMovieIdEquals(int movieId);

    List<Person> findDistincPersonByMovieCrewsJobAndMovieCrews_MovieMovieIdEquals(String director,int movieId);

    @Query(value = "Select * FROM person WHERE person_name = :select", nativeQuery = true)
    Person findByPersonNameContaining(String select);
}
