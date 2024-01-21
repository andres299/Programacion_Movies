package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepo extends JpaRepository<Person, Long> {
    @Query(value = "SELECT MAX(person_id) FROM person", nativeQuery = true)
    int getLastId();

    @Query(value = "SELECT COUNT(*) FROM person WHERE person_id = ?1;", nativeQuery = true)
    long ifEntitiExist(int entityId);
}
