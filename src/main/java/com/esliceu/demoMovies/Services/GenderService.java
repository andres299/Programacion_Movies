package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Repositorys.GenderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderService {
    @Autowired
    GenderRepo genderRepo;
}
