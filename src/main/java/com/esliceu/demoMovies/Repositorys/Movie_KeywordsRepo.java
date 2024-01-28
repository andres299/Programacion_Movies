package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Keyword;
import com.esliceu.demoMovies.Entities.Movie_Keywords;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Movie_KeywordsRepo extends JpaRepository<Movie_Keywords, Long> {
    // Obtiene una lista de Movie_Keywords por ID de palabra clave.
    List<Movie_Keywords> findAllByKeyword_KeywordId(int entityId);
    // Obtiene una lista de Movie_Keywords por ID de película.
    List<Movie_Keywords> findAllByMovie_MovieId(int movieId);
}
