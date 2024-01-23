package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Country;
import com.esliceu.demoMovies.Repositorys.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    CountryRepo countryRepo;

    public List<?> findAll() {
        return countryRepo.findAll();
    }

    public void save(Country country) {
        countryRepo.save(country);
    }

}
