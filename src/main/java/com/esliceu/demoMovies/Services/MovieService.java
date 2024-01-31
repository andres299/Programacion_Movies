package com.esliceu.demoMovies.Services;

import com.esliceu.demoMovies.DTO.*;
import com.esliceu.demoMovies.Entities.*;
import com.esliceu.demoMovies.Repositorys.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
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

    //Devuelve una lista de peliculas por pagina
    public List<Movie> getMovieList(int page) {
        Pageable pageable = PageRequest.of(page,10);
        return movieRepo.findAll(pageable).getContent();
    }

    //Método para filtrar películas según diferentes criterios
    public List<Movie> filterMovies(String filterType, String keyword, int page) {
        // Configuración de paginación
        Pageable pageable = PageRequest.of(page,10);
        //Filtrar por criterio
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
        } // Si no se proporciona un criterio válido, retornar una lista vacía
        return Collections.emptyList();
    }

    //Recupera informacion sobre diferentes entidades
    public List<?> infoEntities(String selectedValue, int page) {
        List<?> listEntiti;
        Pageable pageable = PageRequest.of(page,10);
        //Dependiendo de cual sea la entidad , devuelve una lista de una o otra.
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
    // Mirar si el input esta vacio
    public boolean inputEntitie(String input1) {
        if (input1.length() > 0) return true;
        return false;
    }

    // Método para realizar operaciones en entidades
    public void operationEntitie(FetchEntitiDTO fetchEntitiDTO) {
        int entityId; // Variable para almacenar el ID de la entidad
        // Obtener parámetros de la solicitud
        String operation = fetchEntitiDTO.getOperation();
        String entity = fetchEntitiDTO.getEntity();
        String id = fetchEntitiDTO.getId();
        String input1 = fetchEntitiDTO.getInput1();
        String input2 = fetchEntitiDTO.getInput2();
        // Realizar operación de insertar
        if (operation.equals("insert")) {
            // Casos para diferentes tipos de entidades
            switch (entity) {
                case "country":
                    // Crear y guardar un nuevo país en la base de datos
                    Country country = new Country(input1, input2);
                    countryService.save(country);
                    break;
                case "language":
                    // Crear y guardar un nuevo idioma en la base de datos
                    Language language = new Language(input1, input2);
                    languageService.save(language);
                    break;
                case "language_role":
                    // Obtener el último ID de language_role y crear uno nuevo .
                    Language_role language_roleId = languageRoleService.findFirstByOrderByRoleIdDesc();
                    if (language_roleId != null) {
                        entityId = (language_roleId.getRoleId() != 0) ? language_roleId.getRoleId() + 1 : 1;
                    } else {
                        // Manejar el caso cuando language_roleId es null, por ejemplo, asignar un valor predeterminado a entityId
                        entityId = 1;
                    }
                    Language_role language_role = new Language_role(entityId, input1);
                    languageRoleService.save(language_role);
                    break;
                case "genre":
                    // Obtener el último ID genre de idioma y crear uno nuevo .
                    Genre genreId = genreService.findFirstByOrderByGenreIdDesc();
                    if (genreId != null) {
                        entityId = (genreId.getGenreId() != 0) ? genreId.getGenreId() + 1 : 1;
                    } else {
                        // Manejar el caso cuando genreId es null, asignar un valor predeterminado a entityId
                        entityId = 1;
                    }
                    Genre genre = new Genre(entityId, input1);
                    genreService.save(genre);
                    break;
                case "keyword":
                    // Obtener el último ID de keyword y crear uno nuevo .
                    Keyword keywordId = keywordService.findFirstByOrderByKeywordIdDesc();
                    if (keywordId != null) {
                        entityId = (keywordId.getKeywordId() != 0) ? keywordId.getKeywordId() + 1 : 1;
                    } else {
                        // Manejar el caso cuando keywordId es null, asignar un valor predeterminado a entityId
                        entityId = 1;
                    }
                    Keyword keyword = new Keyword(entityId, input1);
                    keywordService.save(keyword);
                    break;
                case "production_company":
                    // Obtener el último ID production_company y crear uno nuevo .
                    Production_Company productionCompanyId = productionCompanyService.findFirstByOrderByCompanyIdDesc();
                    if (productionCompanyId != null) {
                        entityId = (productionCompanyId.getCompanyId() != 0) ? productionCompanyId.getCompanyId() + 1 : 1;
                    } else {
                        // Manejar el caso cuando productionCompanyId es null, asignar un valor predeterminado a entityId
                        entityId = 1;
                    }
                    Production_Company productionCompany = new Production_Company(entityId, input1);
                    productionCompanyService.save(productionCompany);
                    break;
                case "gender":
                    // Obtener el último ID de gender y crear uno nuevo .
                    Gender genderId = genderService.findFirstByOrderByGenderIdDesc();
                    if (genderId != null) {
                        entityId = (genderId.getGenderId() != 0) ? genderId.getGenderId() + 1 : 1;
                    } else {
                        // Manejar el caso cuando genderId es null, asignar un valor predeterminado a entityId
                        entityId = 1;
                    }
                    Gender gender = new Gender(entityId, input1);
                    genderService.save(gender);
                    break;
                case "person":
                    // Obtener el último ID de person y crear uno nuevo .
                    Person personId = personService.findFirstByOrderByPersonIdDesc();
                    if (personId != null) {
                        entityId = (personId.getPersonId() != 0) ? personId.getPersonId() + 1 : 1;
                    } else {
                        // Manejar el caso cuando personId es null, asignar un valor predeterminado a entityId
                        entityId = 1;
                    }
                    Person person = new Person(entityId, input1);
                    personService.save(person);
                    break;
                case "department":
                    // Crear y guardar un nuevo department en la base de datos
                    Department department = new Department(input1);
                    departmentService.save(department);
                    break;
                default:
            }
        }
        // Manejar operación de eliminación
        else if (operation.equals("delete")) {
            // Comprobamos que existe
            if (existEntiti(entity, id)) {
                // Casos para diferentes tipos de entidades
                switch (entity) {
                    case "country":
                        // Eliminar la entidad del tipo "country" y sus registros.
                        entityId = Integer.parseInt(id);
                        productionCountryService.deleteByCountryId(entityId);
                        countryService.deleteById((long) entityId);
                        break;
                    case "language":
                        // Eliminar la entidad del tipo "language" y sus registros.
                        entityId = Integer.parseInt(id);
                        movieLanguageService.deleteByLanguageId(entityId);
                        languageService.deleteById((long) entityId);
                        break;
                    case "language_role":
                        // Eliminar la entidad del tipo "language_role" y sus registros.
                        entityId = Integer.parseInt(id);
                        movieLanguageService.deleteByLanguageRoleId(entityId);
                        languageRoleService.deleteById((long) entityId);
                        break;
                    case "genre":
                        // Eliminar la entidad del tipo "genre" y sus registros.
                        entityId = Integer.parseInt(id);
                        movieGenresService.deleteByGenreId(entityId);
                        genreService.deleteById((long) entityId);
                        break;
                    case "keyword":
                        // Eliminar la entidad del tipo "keyword" y sus registros.
                        entityId = Integer.parseInt(id);
                        movieKeywordsService.deleteByKeywordId(entityId);
                        keywordService.deleteById((long) entityId);
                        break;
                    case "production_company":
                        // Eliminar la entidad del tipo production_company"" y sus registros.
                        entityId = Integer.parseInt(id);
                        movieCompanyService.deleteByProductionCompany(entityId);
                        productionCompanyService.deleteById((long) entityId);
                        break;
                    case "gender":
                        // Eliminar la entidad del tipo "gender" y sus registros.
                        entityId = Integer.parseInt(id);
                        movieCastService.deleteByGenderId(entityId);
                        genderService.deleteById((long) entityId);
                        break;
                    case "person":
                        entityId = Integer.parseInt(id);
                        // Eliminar la entidad del tipo "person" y sus registros.
                        movieCrewService.deleteByPersonId(entityId);
                        movieCastService.deleteByPersonId(entityId);
                        personService.deleteById((long) entityId);
                        break;
                    case "department":
                        // Eliminar la entidad del tipo "department" y sus registros.
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
        }
        // Manejar operación de actualizar
        else if (operation.equals("update")) {
            // Comprobamos que existe
            if (existEntiti(entity, id)) {
                // Casos para diferentes tipos de entidades
                switch (entity) {
                    case "country":
                        // Convertir el ID a entero y crear una nueva ciudad con la información actualizada
                        entityId = Integer.parseInt(id);
                        Country country = new Country(entityId, input1, input2);
                        countryService.save(country);
                        break;
                    case "language":
                        // Convertir el ID a entero y crear un nuevo language con la información actualizada
                        entityId = Integer.parseInt(id);
                        Language language = new Language(entityId, input1, input2);
                        languageService.save(language);
                        break;
                    case "language_role":
                        // Convertir el ID a entero y crear un language_role con la información actualizada
                        entityId = Integer.parseInt(id);
                        Language_role language_role = new Language_role(entityId, input1);
                        languageRoleService.save(language_role);
                        break;
                    case "genre":
                        // Convertir el ID a entero y crear un genre con la información actualizada
                        entityId = Integer.parseInt(id);
                        Genre genre = new Genre(entityId, input1);
                        genreService.save(genre);
                        break;
                    case "keyword":
                        // Convertir el ID a entero y crear un keyword con la información actualizada
                        entityId = Integer.parseInt(id);
                        Keyword keyword = new Keyword(entityId, input1);
                        keywordService.save(keyword);
                        break;
                    case "production_company":
                        // Convertir el ID a entero y crear un production_company con la información actualizada
                        entityId = Integer.parseInt(id);
                        Production_Company productionCompany = new Production_Company(entityId, input1);
                        productionCompanyService.save(productionCompany);
                        break;
                    case "gender":
                        // Convertir el ID a entero y crear un gender con la información actualizada
                        entityId = Integer.parseInt(id);
                        Gender gender = new Gender(entityId, input1);
                        genderService.save(gender);
                        break;
                    case "person":
                        // Convertir el ID a entero y crear un person con la información actualizada
                        entityId = Integer.parseInt(id);
                        Person person = new Person(entityId, input1);
                        personService.save(person);
                        break;
                    case "department":
                        // Convertir el ID a entero y crear un department con la información actualizada
                        entityId = Integer.parseInt(id);
                        Department department = new Department(entityId, input1);
                        departmentService.save(department);
                        break;
                    default:
                        // Lanzar una excepción indicando que la entidad no se encontró
                        throw new EntityNotFoundException("Entidad no encontrada: " + entity);
                }
            } else {
                // Lanzar una excepción indicando que la id no existe
                throw new entitiExist("Esta id no existe: " + id);
            }
        } else {
            // Lanzar una excepción indicando que la operacion no fue soportada
            throw new UnsupportedOperationException("Operación no soportada: " + operation);
        }
    }

    // Verificar la existencia de una entidad en la base de datos
    private boolean existEntiti(String entity, String id) {
        int entityId = Integer.parseInt(id);
        // Utilizar una expresión switch para contar la cantidad de entidades con la ID dada
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

    // Método para realizar búsquedas paginadas en entidades
    public List<?> searchEntities(FetchEntitiDTO fetchEntitiDTO) {
        // Configuración de paginación
        Pageable pageable = PageRequest.of(fetchEntitiDTO.getPage(), 10);
        // Obtener parámetros para la busqueda
        String entity = fetchEntitiDTO.getEntity();
        String keyword = fetchEntitiDTO.getInput1();
        // Utilizar un switch para los diferentes tipos de entidades
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
                // Búsqueda especial para películas, incluyendo mapeo a DTO
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

    //Este metodo se encarga de realizar operaciones
    // (insertar, actualizar o eliminar) en la entidad movies
    public void operationMovies(OperationMovies movie) {
        // Tipo de entidad y id de movie
        String entity = "movies";
        String entityId = String.valueOf(movie.getMovie_id());
        // Operacion de insertar
        if (movie.getOperation().equals("insert")){
            // Crear una nueva instancia de Movie con la información proporcionada y guardarla en la base de datos
            Movie movieInfo = new Movie(movie.getTitle(),movie.getBudget(),movie.getHomepage(),
                    movie.getOverview(),movie.getPopularity(),movie.getRelease_date(),
                    movie.getRevenue(),movie.getRuntime(),movie.getMovie_status(),
                    movie.getTagline(),movie.getVote_average(),movie.getVote_count());
            movieRepo.save(movieInfo);
        }
        //Operacion de update y comprobar si existe .
        else if (movie.getOperation().equals("update")) {
            if (existEntiti(entity,entityId)){
                // Crear una nueva instancia de Movie con la información actualizada y guardarla en la base de datos
                Movie movieInfo = new Movie(movie.getMovie_id(),movie.getTitle(),movie.getBudget(),
                        movie.getHomepage(),movie.getOverview(),movie.getPopularity(),
                        movie.getRelease_date(),movie.getRevenue(),movie.getRuntime(),
                        movie.getMovie_status(),movie.getTagline(),movie.getVote_average(),
                        movie.getVote_count());
                movieRepo.save(movieInfo);
            } else {
                throw new entitiExist("Esta id no existe: " + entityId);
            }
        }
        //Operacion de eliminar y comprobar si existe .
        else if (movie.getOperation().equals("delete")){
            if (existEntiti(entity,entityId)){
                // Eliminar registros relacionados en otras tablas antes de eliminar la película
                int movie_id = Integer.parseInt(entityId);
                movieLanguageService.deleteByMovieId(movie_id);
                movieKeywordsService.deleteByMovieId(movie_id);
                movieGenresService.deleteByMovieId(movie_id);
                movieCrewService.deleteByMovieId(movie_id);
                movieCompanyService.deleteByMovieId(movie_id);
                movieCastService.deleteByMovieId(movie_id);
                productionCountryService.deleteByMovieId(movie_id);

                // Eliminar la película de la base de datos
                movieRepo.deleteById((long) movie_id);
            }else {
                throw new entitiExist("Esta id no existe: " + entityId);
            }
        }
    }

    // Este metodo obtiene información detallada sobre una película específica a partir de su ID.
    public List<InfoMovies> getInfoMovies(Map<String, Integer> requestBody) {
        // Obtener el ID de la película del cuerpo de la solicitud
        int movieId = requestBody.get("movieId");
        // Buscar la película por su ID en el repositorio
        Movie movie = movieRepo.findById((long) movieId).orElse(null);
        // Lanzar una excepción si la película no existe
        if (movie == null) {
            throw new entitiExist("Esta id no existe: " + movieId);
        }

        // Crear un objeto InfoMovies para almacenar la información detallada
        InfoMovies infoMovies = new InfoMovies();
        infoMovies.setMovieId(movieId);
        infoMovies.setTitle(movie.getTitle());

        //Obtener los directores de la pelicula
        String director = "Director";
        List<Person> directorNames = personService.findDistincPersonByMovieCrewsJobAndMovieCrews_MovieMovieIdEquals
                (director,movieId);
        List<String> directorNameStrings = directorNames.stream()
                .map(Person::getPersonName)
                .collect(Collectors.toList());
        infoMovies.setDirectorName(directorNameStrings);

        // Obtener los personajes y actores emparejados
        Map<String, String> actorCharacterPairs = new HashMap<>();

        // Obtener los personajes personaje
        List<Movie_Cast> characterNames = movieCastService.findCharacterNameByMovieId(movieId);
        for (Movie_Cast movieCast : characterNames) {
            String characterName = movieCast.getCharacterName();

            // Obtener Actores de la pelicula para el personaje actual
            List<Person> actorsForCharacter = personService.findPersonByMoviecast_MovieMovieIdAndMoviecast_CharacterName(movieId, characterName);

            // Asignar cada actor con su personaje correspondiente
            for (Person actor : actorsForCharacter) {
                actorCharacterPairs.put(actor.getPersonName(), characterName);
            }
        }
        // Imprimir o utilizar el mapa como sea necesario
        infoMovies.setActorCharacterPairs(actorCharacterPairs);

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

    //Realiza operaciones relacionadas con la información detallada
    // de una película, como actores, directores y géneros.
    public boolean operationInfoMovies(FetchInfoMoviesDTO fetchInfoMoviesDTO) {
        //Parámetros y Variables Iniciales :
        int movieId = fetchInfoMoviesDTO.getMovieId();
        String entity = fetchInfoMoviesDTO.getEntity();
        String operation = fetchInfoMoviesDTO.getOperation();
        String select = fetchInfoMoviesDTO.getSelected();
        String input1 = fetchInfoMoviesDTO.getInput1();
        String input2 = fetchInfoMoviesDTO.getInput2();
        int genre = fetchInfoMoviesDTO.getGender();
        int cast_Order;
        // Operacion insert y update de Actor
        if (entity.equals("Actor")) {
            if (operation.equals("insert")){
                //Obtengo el id  del actor
                Person person = personService.findByPersonName(input1);
                if (person == null){
                    throw new entitiExist("Usuario no encontrado: " + person.getPersonName());
                }
                // Obtengo la pelicula a la que le quiero insertar un perosnaje
                Movie movie = movieRepo.findById((long) movieId).orElse(null);
                if (movie == null){
                    throw new entitiExist("Movie no encontrada: " + movie.getMovieId());
                }
                // Verificar si la persona ya actúa en la película
                Movie_Cast isActorInMovie = movieCastService.findByPersonAndMovie(person, movie);
                if (isActorInMovie != null){
                    throw new entitiExist("Usuario ya insertado encontrado: " + person.getPersonName());
                }
                //Obtengo el genero seleccionado
                Gender genreEntiti = genderService.findByGenderId(genre);
                // Obtengo el ultimo cast_Order y le sumo uno
                Movie_Cast movieCastCastOrder = movieCastService.findFirstByMovie_MovieIdOrderByCastOrderDesc(movieId);
                if (movieCastCastOrder != null) {
                    cast_Order = (movieCastCastOrder.getCastOrder() != 0) ? movieCastCastOrder.getCastOrder() + 1 : 1;
                } else {
                    // Manejar el caso cuando productionCompanyId es null, asignar un valor predeterminado a entityId
                    cast_Order = 1;
                }
                //Insertar en Movie_Cast esta persona con su personaje
                movieCastService.save(movie, person, input2, genreEntiti, cast_Order);
            } else if (operation.equals("delete")){
                //Eliminar actor de la pelicula
                Person person = personService.findByPersonName(select);
                Movie movie = movieRepo.findById((long) movieId).orElse(null);
                movieCastService.deleteByPersonAndMovie(person,movie);

            }else if (operation.equals("update")){
                //Modificar personaje
                Person person = personService.findByPersonName(select);

                //Obtengo el genero seleccionado
                Gender gender = genderService.findByGenderId(genre);

                // Obtengo la pelicula a la que le quiero insertar un perosnaje
                Movie movie = movieRepo.findById((long) movieId).orElse(null);

                //Borro el registro de la pelicula
                movieCastService.deleteByPersonAndMovie(person,movie);

                // Obtengo el ultimo cast_Order y le sumo uno
                Movie_Cast movieCastCastOrder = movieCastService.findFirstByMovie_MovieIdOrderByCastOrderDesc(movieId);
                if (movieCastCastOrder != null) {
                    cast_Order = (movieCastCastOrder.getCastOrder() != 0) ? movieCastCastOrder.getCastOrder() + 1 : 1;
                } else {
                    // Manejar el caso cuando productionCompanyId es null, asignar un valor predeterminado a entityId
                    cast_Order = 1;
                }

                //Creo con la misma informacion pero con el nuevo register
                movieCastService.save(movie,person,input1,gender,cast_Order);
            }else {
                throw new UnsupportedOperationException("Operación no soportada: " + operation);
            }
        }
        // Operacion insert y update de Director
        else if (entity.equals("Director")) {
            if (operation.equals("insert")){
                //Obtener el departamento
                int departmentId = 2; // Director siempre es departamento 2
                Department department = departmentService.findById(departmentId);

                //Compruebo que existe
                Person person = personService.findByPersonName(input1);
                if (person == null){
                    throw new entitiExist("Usuario no encontrado: " + person.getPersonName());
                }
                // Obtengo la pelicula a la que le quiero insertar un director
                Movie movie = movieRepo.findById((long) movieId).orElse(null);
                if (movie == null){
                    throw new entitiExist("Movie no encontrada: " + movie.getMovieId());
                }
                //Guardo el director en movieCrew
                movieCrewService.save(movie,person,department);

            } else if (operation.equals("delete")){
                //Eliminar Director
                Person person = personService.findByPersonName(select);
                // Obtengo la pelicula a la que le quiero insertar un director
                Movie movie = movieRepo.findById((long) movieId).orElse(null);
                //Borro el registro con ese director de la pelicula
                movieCrewService.deleteByPersonAndMovie(person,movie);

            } else if(operation.equals("update")){
                //Modificar personaje
                Person person = personService.findByPersonName(select);
                person.setPersonName(input1);

                // Inserto el nuevo nombre del director
                personService.save(person);

            }else{
                throw new UnsupportedOperationException("Operación no soportada: " + operation);
            }
        } else {
            // Operacion insert y update de Genero
            if (operation.equals("insert")) {
                //Creo un genero nuevo
                Genre genreId = genreService.findByGenreNameEquals(input1);
                if (genreId == null){
                    throw new entitiExist("Movie no encontrada: " + genreId.getGenreName());
                }
                // Obtengo la pelicula a la que le quiero insertar un genero
                Movie movie = movieRepo.findById((long) movieId).orElse(null);
                if (movie == null){
                    throw new entitiExist("Movie no encontrada: " + movie.getMovieId());
                }
                movieGenresService.save(movie,genreId);

            } else if (operation.equals("delete")) {
                //Eliminar Género
                Genre genreDelte = genreService.findByGenreNameEquals(select);
                if (genreDelte == null){
                    throw new entitiExist("Movie no encontrada: " + genreDelte.getGenreName());
                }
                // Obtengo la pelicula a la que le quiero insertar un genero
                Movie movie = movieRepo.findById((long) movieId).orElse(null);
                if (movie == null){
                    throw new entitiExist("Movie no encontrada: " + movie.getMovieId());
                }
                movieGenresService.deleteByGenreAndMovie(genreDelte,movie);
            } else {
                throw new EntityNotFoundException("Operación no soportada: " + operation);
            }
        }
        return true;
    }

    public List<?> filterPerson(String keyword, int page) {
        Pageable pageable = PageRequest.of(page,10);
        return personService.searchByActor(keyword, pageable);
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

