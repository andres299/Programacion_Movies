package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Country;
import com.esliceu.demoMovies.Entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepo extends JpaRepository<Language, Long> {
}
