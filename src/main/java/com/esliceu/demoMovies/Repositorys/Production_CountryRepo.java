package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Production_Company;
import com.esliceu.demoMovies.Entities.Production_Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Production_CountryRepo extends JpaRepository<Production_Country, Long> {
}
