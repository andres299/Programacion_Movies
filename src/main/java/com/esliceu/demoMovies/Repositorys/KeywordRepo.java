package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordRepo extends JpaRepository<Keyword, Long> {
}
