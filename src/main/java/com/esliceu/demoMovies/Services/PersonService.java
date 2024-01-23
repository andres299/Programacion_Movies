package com.esliceu.demoMovies.Services;

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
}
