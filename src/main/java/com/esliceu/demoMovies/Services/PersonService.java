package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Person;
import com.esliceu.demoMovies.Repositorys.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepo personRepo;

    public List<?> findAll() {
        return personRepo.findAll();
    }

    public Person findFirstByOrderByPersonIdDesc() {
        return personRepo.findFirstByOrderByPersonIdDesc();
    }

    public void save(Person person) {
        personRepo.save(person);
    }

    public void deleteById(long entityId) {
        personRepo.deleteById(entityId);
    }

    public int ifEntitiExist(int entityId) {
        return personRepo.ifEntitiExist(entityId);
    }

    public List<?> findByPersonNameStartingWithIgnoreCase(String keyword) {
        return personRepo.findByPersonNameStartingWithIgnoreCase(keyword);
    }

    public List<Person> findPersonByMoviecast_MovieMovieIdEquals(int movieId) {
        return personRepo.findPersonByMoviecast_MovieMovieIdEquals(movieId);
    }

    public List<Person> findDistincPersonByMovieCrewsJobAndMovieCrews_MovieMovieIdEquals(String director, int movieId) {
        return personRepo.findDistincPersonByMovieCrewsJobAndMovieCrews_MovieMovieIdEquals(director,movieId);
    }
}
