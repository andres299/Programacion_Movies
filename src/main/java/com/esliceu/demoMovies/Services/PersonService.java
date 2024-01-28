package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Person;
import com.esliceu.demoMovies.Repositorys.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepo personRepo;
    // Obtiene todas las personas paginadas.
    public List<?> findAll(Pageable pageable) {
        return personRepo.findAll(pageable).getContent();
    }
    // Encuentra la primera persona ordenada por ID de persona de forma descendente.
    public Person findFirstByOrderByPersonIdDesc() {
        return personRepo.findFirstByOrderByPersonIdDesc();
    }
    // Guarda una nueva persona en la base de datos.
    public void save(Person person) {
        personRepo.save(person);
    }
    // Elimina una persona de la base de datos según su ID.
    public void deleteById(long entityId) {
        personRepo.deleteById(entityId);
    }
    // Cuenta la cantidad de personas con un ID específico.
    public int countPersonsByPersonId(int entityId) {
        return personRepo.countPersonsByPersonId(entityId);
    }
    // Busca personas cuyo nombre comienza con la palabra clave, devolviendo una lista paginada de resultados.
    public List<?> findByPersonNameStartingWithIgnoreCase(String keyword, Pageable pageable) {
        return personRepo.findByPersonNameStartingWithIgnoreCase(keyword,pageable);
    }
    // Busca personas asociadas a un película específica por su elenco (MovieCast).
    public List<Person> findPersonByMoviecast_MovieMovieIdEquals(int movieId) {
        return personRepo.findPersonByMoviecast_MovieMovieIdEquals(movieId);
    }
    // Busca personas distintas asociadas a una película específica por su equipo de producción (MovieCrews)
    // y trabajo (Director).
    public List<Person> findDistincPersonByMovieCrewsJobAndMovieCrews_MovieMovieIdEquals(String director, int movieId) {
        return personRepo.findDistincPersonByMovieCrewsJobAndMovieCrews_MovieMovieIdEquals(director,movieId);
    }
    // Busca una persona por su ID.
    public Person findByPersonId(int lastentityId) {
        return personRepo.findById(Long.valueOf(lastentityId)).orElseThrow();
    }
    // Busca una persona por su nombre.
    public Person findByPersonName(String select) {
        System.out.println(select);
        Person person = personRepo.findByPersonNameContaining(select);
        return person;
    }
}
