package com.esliceu.demoMovies.Repositorys;

import com.esliceu.demoMovies.Entities.Administrator;
import com.esliceu.demoMovies.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginAdminRepo extends JpaRepository<Administrator, Long> {
    // Busca un administrador por su nombre de usuario y contraseña.
    Administrator findByUsernameAndPassword(String username, String password);
    // Obtener un administrador por su nombre de usuario.
    Object findByUsername(String username);
}
