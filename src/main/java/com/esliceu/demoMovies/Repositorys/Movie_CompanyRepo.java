package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Movie_Company;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Movie_CompanyRepo extends JpaRepository<Movie_Company, Long> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM movie_company WHERE movie_id = :movieId", nativeQuery = true)
    void deleteByMovieId(int movieId);
    //List<Movie_Company> findAllByProductionMovie_MovieId(int movieId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM movie_company WHERE company_id = :entityId", nativeQuery = true)
    void deleteByCompanyId(int entityId);
    //List<Movie_Company> findAllByProductionCompany_CompanyId(int entityId);

}
