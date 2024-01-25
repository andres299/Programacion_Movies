package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.DTO.FetchEntitiDTO;
import com.esliceu.demoMovies.DTO.InfoMovies;
import com.esliceu.demoMovies.DTO.OperationMovies;
import com.esliceu.demoMovies.Entities.*;
import com.esliceu.demoMovies.Repositorys.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    MovieRepo movieRepo;
    @Autowired
    CountryService countryService;
    @Autowired
    LanguageService languageService;
    @Autowired DepartmentService departmentService;
    @Autowired
    GenderService genderService;
    @Autowired
    GenreService genreService;
    @Autowired
    KeywordService keywordService;
    @Autowired
    LanguageRoleService languageRoleService;
    @Autowired
    PersonService personService;
    @Autowired
    ProductionCompanyService productionCompanyService;
    @Autowired
    ProductionCountryService productionCountryService;
    @Autowired
    Movie_LanguageService movieLanguageService;
    @Autowired
    Movie_GenresService movieGenresService;
    @Autowired
    Movie_KeywordsService movieKeywordsService;
    @Autowired
    Movie_CompanyService movieCompanyService;
    @Autowired
    Movie_CastService movieCastService;
    @Autowired
    Movie_CrewService movieCrewService;

    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    public List<Movie> filterMovies(String filterType, String keyword) {
        System.out.println("filterMovies llamado con palabra clave: " + keyword + " y tipo de filtro: " + filterType);
        if ("title".equals(filterType)) {
            return movieRepo.findByTitleStartingWithIgnoreCase(keyword);
        } else if ("actor".equals(filterType)) {
            return movieRepo.findMovieByMoviecast_PersonPersonNameContaining(keyword);
        } else if ("characters".equals(filterType)) {
            return movieRepo.findMovieByMoviecastCharacterNameContaining(keyword);
        } else if ("genre".equals(filterType)) {
            return movieRepo.findMovieByMovieGenres_GenreGenreNameContaining(keyword);
        } else if ("director".equals(filterType)) {
            String director = "Director";
            return movieRepo.findDistincMovieByMovieCrewsJobAndMovieCrews_PersonPersonNameContaining(director,keyword);
        }
        return Collections.emptyList();
    }

    public List<Country> getAllCountrys() {
        return (List<Country>) countryService.findAll();
    }

    public List<?> infoEntities(String selectedValue) {
        List<?> listEntiti;

        switch (selectedValue) {
            case "country":
                listEntiti = countryService.findAll();
                break;
            case "language":
                listEntiti = languageService.findAll();
                break;
            case "language_role":
                listEntiti = languageRoleService.findAll();
                break;
            case "genre":
                listEntiti = genreService.findAll();
                break;
            case "keyword":
                listEntiti = keywordService.findAll();
                break;
            case "production_company":
                listEntiti = productionCompanyService.findAll();
                break;
            case "gender":
                listEntiti = genderService.findAll();
                break;
            case "person":
                listEntiti = personService.findAll();
                break;
            case "department":
                listEntiti = departmentService.findAll();
                break;
            case "movies":
                listEntiti = movieRepo.findInfoMovies();
                break;
            default:
                listEntiti = countryService.findAll();
                break;
        }
        return listEntiti;
    }

    public boolean inputEntitie(String input1) {
        if (input1.length() > 0) return true;
        return false;
    }

    public void operationEntitie(FetchEntitiDTO fetchEntitiDTO) {
        int entityId;
        String operation = fetchEntitiDTO.getOperation();
        String entity = fetchEntitiDTO.getEntity();
        String id = fetchEntitiDTO.getId();
        String input1 = fetchEntitiDTO.getInput1();
        String input2 = fetchEntitiDTO.getInput2();
        System.out.println(operation + " " + entity + " " + id + " " + input1 + " " + input2);
        if (operation.equals("insert")) {
            switch (entity) {
                case "country":
                    Country country = new Country(input1, input2);
                    countryService.save(country);
                    break;
                case "language":
                    Language language = new Language(input1, input2);
                    languageService.save(language);
                    break;
                case "language_role":
                    entityId = (languageRoleService.getLastId() != 0) ? languageRoleService.getLastId() + 1 : 1;
                    Language_role language_role = new Language_role(entityId, input1);
                    languageRoleService.save(language_role);
                    break;
                case "genre":
                    entityId = (genreService.getLastId() != 0) ? genreService.getLastId() + 1 : 1;
                    Genre genre = new Genre(entityId, input1);
                    genreService.save(genre);
                    break;
                case "keyword":
                    entityId = (keywordService.getLastId() != 0) ? keywordService.getLastId() + 1 : 1;
                    Keyword keyword = new Keyword(entityId, input1);
                    keywordService.save(keyword);
                    break;
                case "production_company":
                    entityId = (productionCompanyService.getLastId() != 0) ? productionCompanyService.getLastId() + 1 : 1;
                    Production_Company productionCompany = new Production_Company(entityId, input1);
                    productionCompanyService.save(productionCompany);
                    break;
                case "gender":
                    entityId = (genderService.getLastId() != 0) ? genderService.getLastId() + 1 : 1;
                    Gender gender = new Gender(entityId, input1);
                    genderService.save(gender);
                    break;
                case "person":
                    entityId = (personService.getLastId() != 0) ? personService.getLastId() + 1 : 1;
                    Person person = new Person(entityId, input1);
                    personService.save(person);
                    break;
                case "department":
                    Department department = new Department(input1);
                    departmentService.save(department);
                    break;
                default:
            }
        } else if (operation.equals("delete")) {
            if (existEntiti(entity, id)) {
                switch (entity) {
                    case "country":
                        entityId = Integer.parseInt(id);
                        productionCountryService.deleteByCountryId(entityId);
                        countryService.deleteById((long) entityId);
                        break;
                    case "language":
                        entityId = Integer.parseInt(id);
                        movieLanguageService.deleteByLanguageId(entityId);
                        languageService.deleteById((long) entityId);
                        break;
                    case "language_role":
                        entityId = Integer.parseInt(id);
                        movieLanguageService.deleteByLanguageRoleId(entityId);
                        languageRoleService.deleteById((long) entityId);
                        break;
                    case "genre":
                        entityId = Integer.parseInt(id);
                        movieGenresService.deleteByGenreId(entityId);
                        genreService.deleteById((long) entityId);
                        break;
                    case "keyword":
                        entityId = Integer.parseInt(id);
                        movieKeywordsService.deleteByKeywordId(entityId);
                        keywordService.deleteById((long) entityId);
                        break;
                    case "production_company":
                        entityId = Integer.parseInt(id);
                        movieCompanyService.deleteByProductionCompany(entityId);
                        productionCompanyService.deleteById((long) entityId);
                        break;
                    case "gender":
                        entityId = Integer.parseInt(id);
                        movieCastService.deleteByGenderId(entityId);
                        genderService.deleteById((long) entityId);
                        break;
                    case "person":
                        entityId = Integer.parseInt(id);
                        movieCrewService.deleteByPersonId(entityId);
                        movieCastService.deleteByPersonId(entityId);
                        personService.deleteById((long) entityId);
                        break;
                    case "department":
                        entityId = Integer.parseInt(id);
                        movieCrewService.deleteByDepartmentId(entityId);
                        departmentService.deleteById((long) entityId);
                        break;
                    default:
                        throw new EntityNotFoundException("Entidad no encontrada: " + entity);
                }
            } else {
                throw new entitiExist("Esta id no existe: " + id);
            }
        } else if (operation.equals("update")) {
            if (existEntiti(entity, id)) {
                System.out.println("Existe");
                switch (entity) {
                    case "country":
                        entityId = Integer.parseInt(id);
                        Country country = new Country(entityId, input1, input2);
                        countryService.save(country);
                        break;
                    case "language":
                        entityId = Integer.parseInt(id);
                        Language language = new Language(entityId, input1, input2);
                        languageService.save(language);
                        break;
                    case "language_role":
                        entityId = Integer.parseInt(id);
                        Language_role language_role = new Language_role(entityId, input1);
                        languageRoleService.save(language_role);
                        break;
                    case "genre":
                        entityId = Integer.parseInt(id);
                        Genre genre = new Genre(entityId, input1);
                        genreService.save(genre);
                        break;
                    case "keyword":
                        entityId = Integer.parseInt(id);
                        Keyword keyword = new Keyword(entityId, input1);
                        keywordService.save(keyword);
                        break;
                    case "production_company":
                        entityId = Integer.parseInt(id);
                        Production_Company productionCompany = new Production_Company(entityId, input1);
                        productionCompanyService.save(productionCompany);
                        break;
                    case "gender":
                        entityId = Integer.parseInt(id);
                        Gender gender = new Gender(entityId, input1);
                        genderService.save(gender);
                        break;
                    case "person":
                        entityId = Integer.parseInt(id);
                        Person person = new Person(entityId, input1);
                        personService.save(person);
                        break;
                    case "department":
                        entityId = Integer.parseInt(id);
                        Department department = new Department(entityId, input1);
                        departmentService.save(department);
                        break;
                    default:
                        throw new EntityNotFoundException("Entidad no encontrada: " + entity);
                }
            } else {
                System.out.println("NO existe");
                throw new entitiExist("Esta id no existe: " + id);
            }
        } else {
            throw new UnsupportedOperationException("Operación no soportada: " + operation);
        }
    }

    private boolean existEntiti(String entity, String id) {
        int entityId = Integer.parseInt(id);
        return switch (entity) {
            case "country" -> countryService.ifEntitiExist(entityId) > 0;
            case "language" -> languageService.ifEntitiExist(entityId) > 0;
            case "language_role" -> languageRoleService.ifEntitiExist(entityId) > 0;
            case "genre" -> genreService.ifEntitiExist(entityId) > 0;
            case "keyword" -> keywordService.ifEntitiExist(entityId) > 0;
            case "production_company" -> productionCompanyService.ifEntitiExist(entityId) > 0;
            case "gender" -> genderService.ifEntitiExist(entityId) > 0;
            case "person" -> personService.ifEntitiExist(entityId) > 0;
            case "department" -> departmentService.ifEntitiExist(entityId) > 0;
            case "movies" -> movieRepo.ifEntitiExist(entityId) > 0;
            default -> false;
        };

    }

    public List<?> searchEntities(FetchEntitiDTO fetchEntitiDTO) {
        String entity = fetchEntitiDTO.getEntity();
        String keyword = fetchEntitiDTO.getInput1();
        System.out.println(entity + keyword);
        switch (entity) {
            case "country":
                return countryService.findByCountryNameStartingWithIgnoreCase(keyword);
            case "language":
                return languageService.findByLanguageNameStartingWithIgnoreCase(keyword);
            case "language_role":
                return languageRoleService.findByLanguageRoleStartingWithIgnoreCase(keyword);
            case "genre":
                return genreService.findByGenreNameStartingWithIgnoreCase(keyword);
            case "keyword":
                return keywordService.findByKeywordNameStartingWithIgnoreCase(keyword);
            case "production_company":
                return productionCompanyService.findByCompanyNameStartingWithIgnoreCase(keyword);
            case "gender":
                return genderService.findByGenderStartingWithIgnoreCase(keyword);
            case "person":
                return personService.findByPersonNameStartingWithIgnoreCase(keyword);
            case "department":
                return departmentService.findByDepartmentNameStartingWithIgnoreCase(keyword);
            case "movies":
                return movieRepo.findByTitleSelectInfo(keyword);
            default:
                throw new EntityNotFoundException("Entidad no encontrada: " + entity);
        }
    }

    public void operationMovies(OperationMovies movie) {
        String entity = "movies";
        String entityId = String.valueOf(movie.getMovie_id());
        System.out.println(entityId);
        if (movie.getOperation().equals("insert")){
            Movie movieInfo = new Movie(movie.getTitle(),movie.getBudget(),movie.getHomepage(),
                    movie.getOverview(),movie.getPopularity(),movie.getRelease_date(),
                    movie.getRevenue(),movie.getRuntime(),movie.getMovie_status(),
                    movie.getTagline(),movie.getVote_average(),movie.getVote_count());
            movieRepo.save(movieInfo);
        } else if (movie.getOperation().equals("update")) {
            System.out.println(existEntiti(entity,entityId));
            if (existEntiti(entity,entityId)){
                Movie movieInfo = new Movie(movie.getMovie_id(),movie.getTitle(),movie.getBudget(),
                        movie.getHomepage(),movie.getOverview(),movie.getPopularity(),
                        movie.getRelease_date(),movie.getRevenue(),movie.getRuntime(),
                        movie.getMovie_status(),movie.getTagline(),movie.getVote_average(),
                        movie.getVote_count());
                movieRepo.save(movieInfo);
            } else {
                System.out.println("No existe puerco");
                throw new entitiExist("Esta id no existe: " + entityId);
            }
        } else if (movie.getOperation().equals("delete")){
            if (existEntiti(entity,entityId)){
                int movie_id = Integer.parseInt(entityId);
                movieLanguageService.deleteByMovieId(movie_id);
                movieKeywordsService.deleteByMovieId(movie_id);
                movieGenresService.deleteByMovieId(movie_id);
                movieCrewService.deleteByMovieId(movie_id);
                movieCompanyService.deleteByMovieId(movie_id);
                movieCastService.deleteByMovieId(movie_id);
                productionCountryService.deleteByMovieId(movie_id);
                movieRepo.deleteById((long) movie_id);
            }else {
                System.out.println("No existe puerco");
                throw new entitiExist("Esta id no existe: " + entityId);
            }
        }
    }

    public List<InfoMovies> getInfoMovies(Map<String, Integer> requestBody) {
        int movieId = requestBody.get("movieId");
        Movie movie = movieRepo.findById((long) movieId).orElse(null);
        if (movie == null) {
            throw new entitiExist("Esta id no existe: " + movieId);
        }
        InfoMovies infoMovies = new InfoMovies();
        infoMovies.setTitle(movie.getTitle());
        //Obtener Actores de la pelicula
        List<Person> actorNames = personService.findPersonByMoviecast_MovieMovieIdEquals(movieId);
        List<String> actorNameStrings = actorNames.stream()
                .map(Person::getPersonName)
                .collect(Collectors.toList());

        infoMovies.setActorName(actorNameStrings);

        //Obtener los directores de la pelicula
        String director = "Director";
        List<Person> directorNames = personService.findDistincPersonByMovieCrewsJobAndMovieCrews_MovieMovieIdEquals(director,movieId);
        List<String> directorNameStrings = directorNames.stream()
                .map(Person::getPersonName)
                .collect(Collectors.toList());

        infoMovies.setDirectorName(directorNameStrings);


        //Obtener los personajes personaje
        List<Movie_Cast> characterNames = movieCastService.findCharacterNameByMovieId(movieId);
        List<String> characterNameStrings = characterNames.stream()
                .map(Movie_Cast::getCharacterName)
                .collect(Collectors.toList());
        /*
        List<Movie_Cast> filteredCharacters = characterNames.stream()
                .filter(movieCast -> movieCast.getMovie().getMovieId() == movieId)
                .collect(Collectors.toList());
        */
        infoMovies.setCharacterName(characterNameStrings);

        //Obtener los generos de la pelicula
        List<Genre> genres = genreService.findGenreByMovieGenres_MovieMovieIdEquals(movieId);
        List<String> genreNames = genres.stream()
                .map(Genre::getGenreName)
                .collect(Collectors.toList());
        infoMovies.setGenre(genreNames);

        // Colocar el objeto InfoMovies en una lista
        List<InfoMovies> infoMoviesList = new ArrayList<>();
        infoMoviesList.add(infoMovies);

        return infoMoviesList;
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

