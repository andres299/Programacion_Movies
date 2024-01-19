package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepo extends JpaRepository<Gender, Long> {
}
