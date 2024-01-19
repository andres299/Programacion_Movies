package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepo extends JpaRepository<Genre, Long> {
}
