package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Person;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepo extends JpaRepository<Person, Long> {
    // Encuentra la primera persona ordenada por el ID de manera descendente.
    Person findFirstByOrderByPersonIdDesc();
    // Cuenta la cantidad de personas que tienen un ID específico.
    int countPersonsByPersonId(int entityId);
    // Busca personas cuyos nombres comienzan con una palabra clave dada, admitiendo paginación.
    List<Person> findByPersonNameStartingWithIgnoreCase(String keyword, Pageable pageable);
    // Busca personas distintas por el trabajo en el equipo de la película y el ID de la película, admitiendo paginación.
    List<Person> findDistincPersonByMovieCrewsJobAndMovieCrews_MovieMovieIdEquals(String director,int movieId);
    // Busca personas por el nombre, admitiendo paginación.
    @Query(value = "Select * FROM person WHERE person_name = :select", nativeQuery = true)
    Person findByPersonNameContaining(String select);

    // Busca personas basadas en el ID de una película y el nombre de un personaje
    List<Person> findPersonByMoviecast_MovieMovieIdAndMoviecast_CharacterName(
            @Param("movieId")int movieId,
            @Param("characterName") String characterName);

    // Busca personas distintas cuyos nombres coinciden con una palabra clave dada
    @Query(value = "SELECT DISTINCT p.person_id, p.person_name " +
            "FROM person p JOIN movie_cast mc ON p.person_id = mc.person_id WHERE p.person_name LIKE %:keyword%",nativeQuery = true)
    List<?> searchByActor(@Param("keyword") String keyword , Pageable pageable);
}
