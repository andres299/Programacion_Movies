package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Country;
import com.esliceu.demoMovies.Repositorys.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    CountryRepo countryRepo;

    public List<?> findAll(Pageable pageable) {
        return countryRepo.findAll(pageable).getContent();
    }

    public void save(Country country) {
        countryRepo.save(country);
    }

    public void deleteById(long entityId) {
        countryRepo.deleteById(entityId);
    }

    public int countCountriesByCountryId(int entityId) {
        return countryRepo.countCountriesByCountryId(entityId);
    }
    public List<?> findByCountryNameStartingWithIgnoreCase(String keyword) {
        return countryRepo.findByCountryNameStartingWithIgnoreCase(keyword);
    }

    public List<Country> getAllCountrys(int page) {
        Pageable pageable = PageRequest.of(page,10);
        return countryRepo.findAll(pageable).getContent();
    }
}
