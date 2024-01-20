package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.Entities.*;
import com.esliceu.demoMovies.Repositorys.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public boolean inputEntitie(String input1) {
        if (input1.length() > 0) return true;
        return false;
    }

    public void operationEntitie(String operation, String entity, String id, String input1, String input2) {
        int entityId;
        // Si la id es null o no es un número válido, obtén la última id de la base de datos
        try {
            entityId = (id != null) ? Integer.parseInt(id) : countryRepo.findAll().get(countryRepo.findAll().size()-1).getCountry_id() + 1;
        } catch (NumberFormatException e) {
            // Si falla asignamos
            entityId = 1;
        }
        System.out.println(entityId);
        if (operation.equals("insert")){
            switch (entity){
                case "country":
                    Country country = new Country(input1,input2);
                    countryRepo.save(country);
                    break;
                case "language":
                    Language language = new Language(input1,input2);
                    languageRepo.save(language);
                    break;
                case "language_role":
                    entityId = language_roleRepo.getLastId() + 1;
                    Language_role language_role = new Language_role(entityId,input1);
                    language_roleRepo.save(language_role);
                    break;
                case "genre":
                    entityId = genreRepo.getLastId() + 1;
                    Genre genre = new Genre(entityId,input1);
                    genreRepo.save(genre);
                    break;
                case "keyword":
                    entityId = keywordRepo.getLastId() + 1;
                    Keyword keyword = new Keyword(entityId,input1);
                    keywordRepo.save(keyword);
                    break;

                case "production_company":
                    // Agregar lógica para el caso de "production_company"
                    break;
                case "gender":
                    // Agregar lógica para el caso de "gender"
                    break;

                case "person":
                    // Agregar lógica para el caso de "person"
                    break;

                case "department":
                    // Agregar lógica para el caso de "department"
                    break;
                default:
            }
        } else if (operation.equals("delete")) {

        } else if (operation.equals("update")){

        }
    }
}
