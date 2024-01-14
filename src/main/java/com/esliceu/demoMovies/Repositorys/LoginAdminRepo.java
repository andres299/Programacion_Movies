package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Administrator;
import com.esliceu.demoMovies.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginAdminRepo extends JpaRepository<Administrator, Long> {
    Administrator findByUsernameAndPassword(String username, String password);

    Object findByUsername(String username);
}
