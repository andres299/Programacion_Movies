package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GenderRepo extends JpaRepository<Gender, Long> {
    @Query(value = "SELECT MAX(gender_id) FROM gender", nativeQuery = true)
    int getLastId();
}
