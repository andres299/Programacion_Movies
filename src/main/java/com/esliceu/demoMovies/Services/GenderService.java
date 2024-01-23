package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Gender;
import com.esliceu.demoMovies.Repositorys.GenderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderService {
    @Autowired
    GenderRepo genderRepo;

    public List<?> findAll() {
        return genderRepo.findAll();
    }

    public int getLastId() {
        return genderRepo.getLastId();
    }

    public void save(Gender gender) {
        genderRepo.save(gender);
    }
}
