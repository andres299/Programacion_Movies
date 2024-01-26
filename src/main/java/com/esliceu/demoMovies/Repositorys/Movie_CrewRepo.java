package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Movie_Cast;
import com.esliceu.demoMovies.Entities.Movie_Crew;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Movie_CrewRepo extends JpaRepository<Movie_Crew, Long> {

    List<Movie_Crew> findAllByDepartment_DepartmentId(int entityId);

    List<Movie_Crew> findAllByPerson_PersonId(int entityId);

    List<Movie_Crew> findAllByMovie_MovieId(int movieId);
}
