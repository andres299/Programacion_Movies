package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Repositorys.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    @Autowired
    CountryRepo countryRepo;
}
