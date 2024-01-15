package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepo extends JpaRepository<Movie, Long> {
   // @Query(value = "SELECT * FROM movie WHERE title = :keyword",
    //nativeQuery = true)
    List<Movie> findByTitle(String keyword);
}
