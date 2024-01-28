package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.DTO.*;
import com.esliceu.demoMovies.Entities.*;
import com.esliceu.demoMovies.Repositorys.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    
    public List<Movie> getMovieList(int page) {
        Pageable pageable = PageRequest.of(page,10);
        return movieRepo.findAll(pageable).getContent();
    }

    public List<Movie> filterMovies(String filterType, String keyword, int page) {
        Pageable pageable = PageRequest.of(page,10);
        if ("title".equals(filterType)) {
            return movieRepo.findByTitleStartingWithIgnoreCase(keyword,pageable).getContent();
        } else if ("actor".equals(filterType)) {
            return movieRepo.findMovieByMoviecast_PersonPersonNameContaining(keyword,pageable).getContent();
        } else if ("characters".equals(filterType)) {
            return movieRepo.findMovieByMoviecastCharacterNameContaining(keyword,pageable).getContent();
        } else if ("genre".equals(filterType)) {
            return movieRepo.findMovieByMovieGenres_GenreGenreNameContaining(keyword,pageable).getContent();
        } else if ("director".equals(filterType)) {
            String director = "Director";
            return movieRepo.findDistincMovieByMovieCrewsJobAndMovieCrews_PersonPersonNameContaining(director,keyword,pageable).getContent();
        }
        return Collections.emptyList();
    }

    public List<?> infoEntities(String selectedValue, int page) {
        List<?> listEntiti;
        Pageable pageable = PageRequest.of(page,10);
        switch (selectedValue) {
            case "country":
                listEntiti = countryService.findAll(pageable);
                break;
            case "language":
                listEntiti = languageService.findAll(pageable);
                break;
            case "language_role":
                listEntiti = languageRoleService.findAll(pageable);
                break;
            case "genre":
                listEntiti = genreService.findAll(pageable);
                break;
            case "keyword":
                listEntiti = keywordService.findAll(pageable);
                break;
            case "production_company":
                listEntiti = productionCompanyService.findAll(pageable);
                break;
            case "gender":
                listEntiti = genderService.findAll(pageable);
                break;
            case "person":
                listEntiti = personService.findAll(pageable);
                break;
            case "department":
                listEntiti = departmentService.findAll(pageable);
                break;
            case "movies":
                List<Movie> infoMovie = movieRepo.findAll(pageable).getContent();
                List<MovieDTO> movieDTOList = infoMovie.stream()
                        .map(movie -> new MovieDTO(
                                movie.getMovieId(),
                                movie.getTitle(),
                                movie.getOverview(),
                                movie.getPopularity(),
                                movie.getReleaseDate(),
                                movie.getRevenue()
                        ))
                        .collect(Collectors.toList());
                listEntiti = movieDTOList;
                break;
            default:
                listEntiti = countryService.findAll(pageable);
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
                    Language_role language_roleId = languageRoleService.findFirstByOrderByRoleIdDesc();
                    entityId = (language_roleId.getRoleId() != 0) ? language_roleId.getRoleId() + 1 : 1;
                    Language_role language_role = new Language_role(entityId, input1);
                    languageRoleService.save(language_role);
                    break;
                case "genre":
                    Genre genreId = genreService.findFirstByOrderByGenreIdDesc();
                    entityId = (genreId.getGenreId() != 0) ? genreId.getGenreId() + 1 : 1;
                    Genre genre = new Genre(entityId, input1);
                    genreService.save(genre);
                    break;
                case "keyword":
                    Keyword keywordId = keywordService.findFirstByOrderByKeywordIdDesc();
                    entityId = (keywordId.getKeywordId() != 0) ? keywordId.getKeywordId() + 1 : 1;
                    Keyword keyword = new Keyword(entityId, input1);
                    keywordService.save(keyword);
                    break;
                case "production_company":
                    Production_Company productionCompanyId = productionCompanyService.findFirstByOrderByCompanyIdDesc();
                    entityId = (productionCompanyId.getCompanyId() != 0) ? productionCompanyId.getCompanyId() + 1 : 1;
                    Production_Company productionCompany = new Production_Company(entityId, input1);
                    productionCompanyService.save(productionCompany);
                    break;
                case "gender":
                    Gender genderId = genderService.findFirstByOrderByGenderIdDesc();
                    entityId = (genderId.getGenderId() != 0) ? genderId.getGenderId() + 1 : 1;
                    Gender gender = new Gender(entityId, input1);
                    genderService.save(gender);
                    break;
                case "person":
                    Person personId = personService.findFirstByOrderByPersonIdDesc();
                    entityId = (personId.getPersonId() != 0) ? personId.getPersonId() + 1 : 1;
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
                    case "gender": //Poner consulta Query
                        entityId = Integer.parseInt(id);
                        movieCastService.deleteByGenderId(entityId);
                        genderService.deleteById((long) entityId);
                        break;
                    case "person": //Poner consulta query
                        entityId = Integer.parseInt(id);
                        movieCrewService.deleteByPersonId(entityId);
                        movieCastService.deleteByPersonId(entityId);
                        personService.deleteById((long) entityId);
                        break;
                    case "department": //Poner consulta query
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
            case "country" -> countryService.countCountriesByCountryId(entityId) > 0;
            case "language" -> languageService.countLanguagesByLanguageId(entityId) > 0;
            case "language_role" -> languageRoleService.countLanguageRolesByRoleId(entityId) > 0;
            case "genre" -> genreService.countGenresByGenreId(entityId) > 0;
            case "keyword" -> keywordService.countKeywordsByKeywordId(entityId) > 0;
            case "production_company" -> productionCompanyService.countProductionCompaniesByCompanyId(entityId) > 0;
            case "gender" -> genderService.countGendersByGenderId(entityId) > 0;
            case "person" -> personService.countPersonsByPersonId(entityId) > 0;
            case "department" -> departmentService.countDepartmentsByDepartmentId(entityId) > 0;
            case "movies" -> movieRepo.countMoviesByMovieId(entityId) > 0;
            default -> false;
        };

    }

    public List<?> searchEntities(FetchEntitiDTO fetchEntitiDTO) {
        Pageable pageable = PageRequest.of(fetchEntitiDTO.getPage(), 10);
        String entity = fetchEntitiDTO.getEntity();
        String keyword = fetchEntitiDTO.getInput1();
        switch (entity) {
            case "country":
                return countryService.findByCountryNameStartingWithIgnoreCase(keyword,pageable);
            case "language":
                return languageService.findByLanguageNameStartingWithIgnoreCase(keyword,pageable);
            case "language_role":
                return languageRoleService.findByLanguageRoleStartingWithIgnoreCase(keyword,pageable);
            case "genre":
                return genreService.findByGenreNameStartingWithIgnoreCase(keyword,pageable);
            case "keyword":
                return keywordService.findByKeywordNameStartingWithIgnoreCase(keyword,pageable);
            case "production_company":
                return productionCompanyService.findByCompanyNameStartingWithIgnoreCase(keyword,pageable);
            case "gender":
                return genderService.findByGenderStartingWithIgnoreCase(keyword,pageable);
            case "person":
                return personService.findByPersonNameStartingWithIgnoreCase(keyword,pageable);
            case "department":
                return departmentService.findByDepartmentNameStartingWithIgnoreCase(keyword,pageable);
            case "movies":
                List<Movie> movies = movieRepo.findByTitleStartingWithIgnoreCase(keyword,pageable).getContent();
                List<MovieDTO> movieDTOList = movies.stream()
                        .map(movie -> new MovieDTO(
                                movie.getMovieId(),
                                movie.getTitle(),
                                movie.getOverview(),
                                movie.getPopularity(),
                                movie.getReleaseDate(),
                                movie.getRevenue()
                        ))
                        .collect(Collectors.toList());
                return movieDTOList;
            default:
                throw new EntityNotFoundException("Entidad no encontrada: " + entity);
        }
    }

    public void operationMovies(OperationMovies movie) {
        String entity = "movies";
        String entityId = String.valueOf(movie.getMovie_id());
        if (movie.getOperation().equals("insert")){
            Movie movieInfo = new Movie(movie.getTitle(),movie.getBudget(),movie.getHomepage(),
                    movie.getOverview(),movie.getPopularity(),movie.getRelease_date(),
                    movie.getRevenue(),movie.getRuntime(),movie.getMovie_status(),
                    movie.getTagline(),movie.getVote_average(),movie.getVote_count());
            movieRepo.save(movieInfo);
        } else if (movie.getOperation().equals("update")) {
            if (existEntiti(entity,entityId)){
                Movie movieInfo = new Movie(movie.getMovie_id(),movie.getTitle(),movie.getBudget(),
                        movie.getHomepage(),movie.getOverview(),movie.getPopularity(),
                        movie.getRelease_date(),movie.getRevenue(),movie.getRuntime(),
                        movie.getMovie_status(),movie.getTagline(),movie.getVote_average(),
                        movie.getVote_count());
                movieRepo.save(movieInfo);
            } else {
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

    public boolean operationInfoMovies(FetchInfoMoviesDTO fetchInfoMoviesDTO) {
        int movieId = fetchInfoMoviesDTO.getMovieId();
        String entity = fetchInfoMoviesDTO.getEntity();
        String operation = fetchInfoMoviesDTO.getOperation();
        String select = fetchInfoMoviesDTO.getSelected();
        String input1 = fetchInfoMoviesDTO.getInput1();
        String input2 = fetchInfoMoviesDTO.getInput2();
        int genre = fetchInfoMoviesDTO.getGender();
        int LastentityId;
        if (entity.equals("Actor")) {
            if (operation.equals("insert")){
                //Creo una persona y la guardo en la Base de datos
                Person personId = personService.findFirstByOrderByPersonIdDesc();
                LastentityId = (personId.getPersonId() != 0) ? personId.getPersonId() + 1 : 1;
                Person person = new Person(LastentityId, input1);
                personService.save(person);
                //Despues obtengo la ultima persona registrada
                person = personService.findByPersonId(LastentityId);

                //Obtengo el genero seleccionado
                Gender genreEntiti = genderService.findByGenderId(genre);

                // Obtengo la pelicula a la que le quiero insertar un perosnaje
                Movie movie = movieRepo.findById((long) movieId).orElse(null);

                // Insertar en Movie_Cast esta persona con su personaje
                movieCastService.save(movie, person, input2, genreEntiti);
            } else if (operation.equals("delete")){
                Person person = personService.findByPersonName(select);
                movieCrewService.deleteByPersonId(person.getPersonId());
                movieCastService.deleteByPersonId(person.getPersonId());
                personService.deleteById((long) person.getPersonId());
            }else {
                throw new UnsupportedOperationException("Operación no soportada: " + operation);
            }
        } else if (entity.equals("Director")) {
            if (operation.equals("insert")){
                int departmentId = 2;
                Department department = departmentService.findById(departmentId);

                //Creo una persona y la guardo en la Base de datos
                Person personId = personService.findFirstByOrderByPersonIdDesc();
                LastentityId = (personId.getPersonId() != 0) ? personId.getPersonId() + 1 : 1;
                Person person = new Person(LastentityId, input1);
                personService.save(person);
                //Despues obtengo la ultima persona registrada
                person = personService.findByPersonId(LastentityId);

                // Obtengo la pelicula a la que le quiero insertar un director
                Movie movie = movieRepo.findById((long) movieId).orElse(null);

                movieCrewService.save(movie,person,department);

            } else if (operation.equals("delete")){
                Person person = personService.findByPersonName(select);
                movieCrewService.deleteByPersonId(person.getPersonId());
                personService.deleteById((long) person.getPersonId());
            } else{
                throw new UnsupportedOperationException("Operación no soportada: " + operation);

            }
        } else {
            if (operation.equals("insert")) {
                //Creo un genero nuevo
                Genre genreId = genreService.findFirstByOrderByGenreIdDesc();
                LastentityId = (genreId.getGenreId() != 0) ? genreId.getGenreId() + 1 : 1;
                Genre newGenre = new Genre(LastentityId, input1);
                genreService.save(newGenre);

                //Despues obtengo el ultimo genero registrada
                newGenre = genreService.findFirstByOrderByGenreIdDesc();

                // Obtengo la pelicula a la que le quiero insertar un genero
                Movie movie = movieRepo.findById((long) movieId).orElse(null);
                movieGenresService.save(movie,newGenre);

            } else if (operation.equals("delete")) {
                LastentityId = movieId;
                movieGenresService.deleteByGenreId(LastentityId);
                genreService.deleteById((long) LastentityId);
            } else {
                throw new EntityNotFoundException("Operación no soportada: " + operation);

            }

        }
        return true;
    }

    //Manejo las diferentes excepciones que puedan salir, si la entidad no es entontada
    //, si es country ,genre ...
    public class EntityNotFoundException extends RuntimeException {
        public EntityNotFoundException(String message) {
            super(message);
        }
    }
    //Si no existe la id que estoy buscando
    public class entitiExist extends RuntimeException {
        public entitiExist(String message) {
            super(message);
        }
    }
}

