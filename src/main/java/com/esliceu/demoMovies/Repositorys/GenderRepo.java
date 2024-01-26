package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GenderRepo extends JpaRepository<Gender, Long> {
    Gender findFirstByOrderByGenderIdDesc();

    int countGendersByGenderId(int entityId);

    List<Gender> findByGenderStartingWithIgnoreCase(String keyword);
}
