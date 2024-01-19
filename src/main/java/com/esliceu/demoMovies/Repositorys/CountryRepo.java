package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country, Long> {
}
