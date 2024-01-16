package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepo extends JpaRepository<Movie, Long> {
   // @Query(value = "SELECT * FROM movie WHERE title = :keyword",
    //nativeQuery = true)
    List<Movie> findByTitle(String keyword);

    @Query(value = "SELECT m.* FROM movie m " +
            "JOIN movie_cast mc ON m.movie_id = mc.movie_id " +
            "JOIN person p ON mc.person_id = p.person_id " +
            "WHERE p.person_name = :person_name", nativeQuery = true)
    /*
    @Query(value = "SELECT m.* FROM movie m " +
            "JOIN movie_cast mc ON m.movie_id = mc.movie_id " +
            "JOIN person p ON mc.person_id = p.person_id " +
            "WHERE p.person_name LIKE %:person_name%", nativeQuery = true)
     */
    List<Movie> findByMoviecast_Person_person_name(String person_name);
}
