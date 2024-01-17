package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepo extends JpaRepository<Movie, Long> {
   // @Query(value = "SELECT * FROM movie WHERE title = :keyword",
    //nativeQuery = true)
    List<Movie> findByTitleContaining(String keyword);

     /*
    @Query(value = "SELECT m.* FROM movie m " +
            "JOIN movie_cast mc ON m.movie_id = mc.movie_id " +
            "JOIN person p ON mc.person_id = p.person_id " +
            "WHERE p.person_name = :person_name", nativeQuery = true)
      */
    @Query(value = "SELECT m.* FROM movie m " +
            "JOIN movie_cast mc ON m.movie_id = mc.movie_id " +
            "JOIN person p ON mc.person_id = p.person_id " +
            "WHERE p.person_name LIKE %:person_name%", nativeQuery = true)

    List<Movie> findByMoviecast_Person_person_nameContaining(String person_name);

    @Query(value = "SELECT m.* FROM movie m " +
            "JOIN movie_cast mc ON m.movie_id = mc.movie_id " +
            "WHERE mc.character_name LIKE %:character_name%", nativeQuery = true)
    List<Movie> findByCharacterNameContaining(String character_name);

    @Query(value = "SELECT m.* FROM movie m " +
            "JOIN movie_genres mg ON m.movie_id = mg.movie_id " +
            "JOIN genre g ON mg.genre_id = g.genre_id " +
            "WHERE g.genre_name LIKE %:genre%", nativeQuery = true)
    List<Movie> findByGenreNameContaining( String genre);

 @Query(value = "SELECT m.* FROM movie m " +
         "JOIN movie_crew mc ON m.movie_id = mc.movie_id " +
         "JOIN person p ON mc.person_id = p.person_id " +
         "WHERE mc.job = 'Director' AND p.person_name LIKE %:director%", nativeQuery = true)
    List<Movie> findByDirectorNameContaining(String director);

}
