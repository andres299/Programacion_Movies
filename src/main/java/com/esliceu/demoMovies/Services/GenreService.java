package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Genre;
import com.esliceu.demoMovies.Repositorys.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    @Autowired
    GenreRepo genreRepo;

    public List<?> findAll(Pageable pageable) {
        return genreRepo.findAll(pageable).getContent();
    }

    public Genre findFirstByOrderByGenreIdDesc() {
        return genreRepo.findFirstByOrderByGenreIdDesc();
    }
    public void deleteById(long entityId) {
        genreRepo.deleteById(entityId);
    }

    public void save(Genre genre) {
        genreRepo.save(genre);
    }

    public int countGenresByGenreId(int entityId) {
        return genreRepo.countGenresByGenreId(entityId);
    }
    public List<?> findByGenreNameStartingWithIgnoreCase(String keyword, Pageable pageable) {
        return genreRepo.findByGenreNameStartingWithIgnoreCase(keyword,pageable);
    }

    public List<Genre> findGenreByMovieGenres_MovieMovieIdEquals(int movieId) {
        return genreRepo.findGenreByMovieGenres_MovieMovieIdEquals(movieId);
    }
}
