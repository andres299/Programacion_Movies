package com.esliceu.demoMovies.Controllers;

import com.esliceu.demoMovies.DTO.FetchInfoMoviesDTO;
import com.esliceu.demoMovies.DTO.InfoMovies;
import com.esliceu.demoMovies.DTO.OperationMovies;
import com.esliceu.demoMovies.Entities.Administrator;
import com.esliceu.demoMovies.Entities.Movie;
import com.esliceu.demoMovies.Services.MovieService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

@Controller
public class FilterController {
    @Autowired
    HttpSession session;

    @Autowired
    MovieService movieService;

    @GetMapping("/filterMovies")
    public String showMovies(Model model, @RequestParam(defaultValue = "0") int page){
        //Obtenemos la sesion actual si la hay.
        Administrator admin = (Administrator) session.getAttribute("admin");
        // Agregamos un atributo al modelo para verificar si el administrador está autenticado.
        model.addAttribute("isAdminNotNull", admin != null);
        //Agregamos la lista de películas al modelo utilizando el servicio movieService.
        model.addAttribute("listOfMovies",movieService.getMovieList(page));
        return "filterMovies";
    }
    @PostMapping("/changePageMovies")
    @ResponseBody
    public List<Movie> changePageMovies(@RequestParam int page) {
        // Devuelve la lista de películas correspondiente a la página proporcionada.
        return movieService.getMovieList(page);
    }

    @PostMapping("/filterMovies")
    @ResponseBody
    public List<Movie> filterMovies(@RequestParam String filterType, @RequestParam String keyword, @RequestParam int page) {
        // Retorna la lista de películas filtrada según los parámetros proporcionados.
        return movieService.filterMovies(filterType,keyword,page);
    }

    @PostMapping("/infoMovies")
    @ResponseBody
    public List<InfoMovies> infoMovies(@RequestBody Map<String, Integer> requestBody) {
        // Retorna una lista de información de películas: actores, personajes, directores ,genero.
        return movieService.getInfoMovies(requestBody);
    }
    @PostMapping("/operationInfoMovies")
    ResponseEntity<String> operationInfoMovies(@RequestBody FetchInfoMoviesDTO fetchInfoMoviesDTO){
        // Obtiene el administrador de la sesión actual.
        Administrator admin = (Administrator) session.getAttribute("admin");
        // Verifica si el administrador está autenticado.
        //if (admin == null) {
          //  return ResponseEntity.badRequest().body("Error: El administrador no está autenticado");
        //}
        // Llamar al servicio para realizar la operación
        boolean operationResult = movieService.operationInfoMovies(fetchInfoMoviesDTO);
        if (operationResult) {
            // Si la operación fue exitosa
            return ResponseEntity.ok("Se ha realizado correctamente");
        } else {
            // Si la operación falló devuelve error
            return ResponseEntity.badRequest().body("Error: Entrada no válida para la entidad");
        }
    }

    @PostMapping("/filterPerson")
    @ResponseBody
    public List<?> filterPerson(@RequestParam String keyword, @RequestParam int page) {
        // Retorna la lista de películas filtrada según los parámetros proporcionados.
        return movieService.filterPerson(keyword,page);
    }
}
