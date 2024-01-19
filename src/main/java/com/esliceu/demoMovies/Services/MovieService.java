package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.Country;
import com.esliceu.demoMovies.Entities.Keyword;
import com.esliceu.demoMovies.Entities.Movie;
import com.esliceu.demoMovies.Repositorys.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepo movieRepo;
    @Autowired
    CountryRepo countryRepo;
    @Autowired
    LanguageRepo languageRepo;
    @Autowired
    DepartmentRepo departmentRepo;
    @Autowired
    GenderRepo genderRepo;
    @Autowired
    GenreRepo genreRepo;
    @Autowired
    KeywordRepo keywordRepo;
    @Autowired
    Language_roleRepo language_roleRepo;
    @Autowired
    PersonRepo personRepo;
    @Autowired
    Production_CompanyRepo productionCompanyRepo;

    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    public List<Movie> getFirstMovies() {
        List<Movie> firstMovies = movieRepo.findAll();
        return firstMovies.subList(0,10);
    }

    public List<Movie> getAllMoviesByPage(int page) {
        List<Movie> allMovies = movieRepo.findAll();
        int pageSize = 10;
        int start = Math.toIntExact(page * pageSize);
        int end = Math.toIntExact(Math.min((page + 1) * pageSize, allMovies.size()));
        return allMovies.subList(start,end);
    }

    public List<Movie> filterMovies(String filterType ,String keyword) {
        System.out.println("filterMovies llamado con palabra clave: " + keyword + " y tipo de filtro: " + filterType);
        if ("title".equals(filterType)) {
            return movieRepo.findByTitleStartingWithIgnoreCase(keyword);
        } else if ("actor".equals(filterType)) {
            return movieRepo.findByMoviecast_Person_person_nameContaining(keyword);
        } else if ("characters".equals(filterType)){
            return movieRepo.findByCharacterNameContaining(keyword);
        } else if ("genre".equals(filterType)) {
            return movieRepo.findByGenreNameContaining(keyword);
        } else if ("director".equals(filterType)) {
            return movieRepo.findByDirectorNameContaining(keyword);
        }
        return Collections.emptyList();
    }

    public List<Country> getAllCountrys() {
        return countryRepo.findAll();
    }

    public List<?> infoEntities(String selectedValue) {
        List<?> listEntiti = new ArrayList<>();

        switch (selectedValue) {
            case "country":
                listEntiti = countryRepo.findAll();
                break;
            case "language":
                listEntiti = languageRepo.findAll();
                break;
            case "language_role":
                listEntiti = language_roleRepo.findAll();
                break;
            case "genre":
                listEntiti = genreRepo.findAll();
                break;
            case "keyword":
                listEntiti = keywordRepo.findAll();
                break;
            case "production_company":
                listEntiti = productionCompanyRepo.findAll();
                break;
            case "gender":
                listEntiti = genderRepo.findAll();
                break;
            case "person":
                listEntiti = personRepo.findAll();
                break;
            case "department":
                listEntiti = departmentRepo.findAll();
                break;
            default:
                listEntiti = countryRepo.findAll();
                break;
        }
        return listEntiti;
    }
}
