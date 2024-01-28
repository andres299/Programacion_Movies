package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Person;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepo extends JpaRepository<Person, Long> {
    // Encuentra la primera persona ordenada por el ID de manera descendente.
    Person findFirstByOrderByPersonIdDesc();
    // Cuenta la cantidad de personas que tienen un ID específico.
    int countPersonsByPersonId(int entityId);
    // Busca personas cuyos nombres comienzan con una palabra clave dada, admitiendo paginación.
    List<Person> findByPersonNameStartingWithIgnoreCase(String keyword, Pageable pageable);
    // Busca personas por el ID de la película en la que participan, admitiendo paginación.
    List<Person> findPersonByMoviecast_MovieMovieIdEquals(int movieId);
    // Busca personas distintas por el trabajo en el equipo de la película y el ID de la película, admitiendo paginación.
    List<Person> findDistincPersonByMovieCrewsJobAndMovieCrews_MovieMovieIdEquals(String director,int movieId);
    // Busca personas por el nombre, admitiendo paginación.
    @Query(value = "Select * FROM person WHERE person_name = :select", nativeQuery = true)
    Person findByPersonNameContaining(String select);
}
