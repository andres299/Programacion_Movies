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
        return firstMovies.subList(0, 10);
    }

    public List<Movie> getAllMoviesByPage(int page) {
        List<Movie> allMovies = movieRepo.findAll();
        int pageSize = 10;
        int start = Math.toIntExact(page * pageSize);
        int end = Math.toIntExact(Math.min((page + 1) * pageSize, allMovies.size()));
        return allMovies.subList(start, end);
    }

    public List<Movie> filterMovies(String filterType, String keyword) {
        System.out.println("filterMovies llamado con palabra clave: " + keyword + " y tipo de filtro: " + filterType);
        if ("title".equals(filterType)) {
            return movieRepo.findByTitleStartingWithIgnoreCase(keyword);
        } else if ("actor".equals(filterType)) {
            return movieRepo.findByMoviecast_Person_person_nameContaining(keyword);
        } else if ("characters".equals(filterType)) {
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
        System.out.println(operation + " " + entity + " " + id + " " + input1 + " " + input2);
        if (operation.equals("insert")) {
            switch (entity) {
                case "country":
                    Country country = new Country(input1, input2);
                    countryRepo.save(country);
                    break;
                case "language":
                    Language language = new Language(input1, input2);
                    languageRepo.save(language);
                    break;
                case "language_role":
                    entityId = (language_roleRepo.getLastId() != 0) ? language_roleRepo.getLastId() + 1 : 1;
                    System.out.println(entityId + input1);
                    Language_role language_role = new Language_role(entityId, input1);
                    language_roleRepo.save(language_role);
                    break;
                case "genre":
                    entityId = (genreRepo.getLastId() != 0) ? genreRepo.getLastId() + 1 : 1;
                    Genre genre = new Genre(entityId, input1);
                    genreRepo.save(genre);
                    break;
                case "keyword":
                    entityId = (keywordRepo.getLastId() != 0) ? keywordRepo.getLastId() + 1 : 1;
                    Keyword keyword = new Keyword(entityId, input1);
                    keywordRepo.save(keyword);
                    break;
                case "production_company":
                    // Agregar lógica para el caso de "production_company"
                    entityId = (productionCompanyRepo.getLastId() != 0) ? productionCompanyRepo.getLastId() + 1 : 1;
                    Production_Company productionCompany = new Production_Company(entityId, input1);
                    productionCompanyRepo.save(productionCompany);
                    break;
                case "gender":
                    // Agregar lógica para el caso de "gender"
                    entityId = (genderRepo.getLastId() != 0) ? genderRepo.getLastId() + 1 : 1;
                    Gender gender = new Gender(entityId, input1);
                    genderRepo.save(gender);
                    break;
                case "person":
                    // Agregar lógica para el caso de "person"
                    entityId = (personRepo.getLastId() != 0) ? personRepo.getLastId() + 1 : 1;
                    Person person = new Person(entityId, input1);
                    personRepo.save(person);
                    break;
                case "department":
                    // Agregar lógica para el caso de "department"
                    Department department = new Department(input1);
                    departmentRepo.save(department);
                    break;
                default:
            }
        } else if (operation.equals("delete")) {

        } else if (operation.equals("update")) {
            if (existEnttiti(entity, id)) {
                switch (entity) {
                    case "country":
                        entityId = Integer.parseInt(id);
                        Country country = new Country(entityId, input1, input2);
                        countryRepo.save(country);
                        break;
                    case "language":
                        entityId = Integer.parseInt(id);
                        Language language = new Language(entityId, input1, input2);
                        languageRepo.save(language);
                        break;
                    case "language_role":
                        entityId = Integer.parseInt(id);
                        Language_role language_role = new Language_role(entityId, input1);
                        language_roleRepo.save(language_role);
                        break;
                    case "genre":
                        entityId = Integer.parseInt(id);
                        Genre genre = new Genre(entityId, input1);
                        genreRepo.save(genre);
                        break;
                    case "keyword":
                        entityId = Integer.parseInt(id);
                        Keyword keyword = new Keyword(entityId, input1);
                        keywordRepo.save(keyword);
                        break;
                    case "production_company":
                        // Agregar lógica para el caso de "production_company"
                        entityId = Integer.parseInt(id);
                        Production_Company productionCompany = new Production_Company(entityId, input1);
                        productionCompanyRepo.save(productionCompany);
                        break;
                    case "gender":
                        // Agregar lógica para el caso de "gender"
                        entityId = Integer.parseInt(id);
                        Gender gender = new Gender(entityId, input1);
                        genderRepo.save(gender);
                        break;
                    case "person":
                        // Agregar lógica para el caso de "person"
                        entityId = Integer.parseInt(id);
                        Person person = new Person(entityId, input1);
                        personRepo.save(person);
                        break;
                    case "department":
                        // Agregar lógica para el caso de "department"
                        entityId = Integer.parseInt(id);
                        Department department = new Department(entityId, input1);
                        departmentRepo.save(department);
                        break;
                    default:
                        throw new EntityNotFoundException("Entidad no encontrada: " + entity);
                }
            } else {
                throw new entitiExist("Esta entidad no existe: " + entity);
            }
        } else {
            throw new UnsupportedOperationException("Operación no soportada: " + operation);
        }
    }

    private boolean existEnttiti(String entity, String id) {
        int entityId;
        try {
            entityId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return false;
        }
        switch (entity) {
            case "country":
                return countryRepo.ifEntitiExist(entityId);
            case "language":
                return languageRepo.ifEntitiExist(entityId);
            case "language_role":
                return language_roleRepo.ifEntitiExist(entityId);
            case "genre":
                return genreRepo.ifEntitiExist(entityId);
            case "keyword":
                return keywordRepo.ifEntitiExist(entityId);
            case "production_company":
                return productionCompanyRepo.ifEntitiExist(entityId);
            case "gender":
                return genderRepo.ifEntitiExist(entityId);
            case "person":
                return personRepo.ifEntitiExist(entityId);
            case "department":
                return departmentRepo.ifEntitiExist(entityId);
            default:
                return false;
        }
    }

    public class EntityNotFoundException extends RuntimeException {
        public EntityNotFoundException(String message) {
            super(message);
        }
    }

    public class entitiExist extends RuntimeException {
        public entitiExist(String message) {
            super(message);
        }
    }
}

