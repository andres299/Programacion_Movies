package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Gender;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenderRepo extends JpaRepository<Gender, Long> {
    Gender findFirstByOrderByGenderIdDesc();

    int countGendersByGenderId(int entityId);

    List<Gender> findByGenderStartingWithIgnoreCase(String keyword, Pageable pageable);
}
