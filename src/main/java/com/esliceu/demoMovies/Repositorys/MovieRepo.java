package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepo extends JpaRepository<Movie, Long> {
    List<Movie> findByTitle(String title);
}
