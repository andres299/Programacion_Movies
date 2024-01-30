package com.esliceu.demoMovies.Controllers;

import com.esliceu.demoMovies.DTO.FetchEntitiDTO;
import com.esliceu.demoMovies.DTO.OperationMovies;
import com.esliceu.demoMovies.Entities.Administrator;
import com.esliceu.demoMovies.Entities.Country;
import com.esliceu.demoMovies.Entities.Movie;
import com.esliceu.demoMovies.Services.AdminService;
import com.esliceu.demoMovies.Services.CountryService;
import com.esliceu.demoMovies.Services.MovieService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CrudController {
    @Autowired
    MovieService movieService;
    @Autowired
    CountryService countryService;
    @Autowired
    HttpSession session;

    @GetMapping("/crud")
    public String showCrud(Model model, @RequestParam(defaultValue = "0") int page) {
        // Obtiene el administrador de la sesión actual.
        Administrator admin = (Administrator) session.getAttribute("admin");
        // Verifica si el administrador no está autenticado y lo redirige a la página de filtrado de películas.
        if (admin == null) {
            return "redirect:/filterMovies";
        }
        // Agrega la lista de países al modelo para su uso en la vista.
        model.addAttribute("listCountries", countryService.getAllCountrys(page));
        return "crud";
    }

    @PostMapping("/infoEntities")
    @ResponseBody
    public List<?> crud(@RequestParam String selectedValue,@RequestParam int page){
        // Retorna una lista de entidades según el parametro seleccionado por el usuario.
        return movieService.infoEntities(selectedValue,page);}

    @PostMapping("/searchEntities")
    @ResponseBody
    public List<?> searchEntities(@RequestBody FetchEntitiDTO fetchEntitiDTO) {
        // Retorna una lista de entidades, es como un buscador.
        return movieService.searchEntities(fetchEntitiDTO);
    }
    @PostMapping("/operationEntities")
    public ResponseEntity<String> operationEntities(@RequestBody FetchEntitiDTO fetchEntitiDTO) {
        // Obtiene el administrador de la sesión actual.
        Administrator admin = (Administrator) session.getAttribute("admin");
        //Obtiene el primer input.
        String input1 = fetchEntitiDTO.getInput1();
        try {
            //Si el primer imput esta vacio devuelve mensaje de error
            if (movieService.inputEntitie(input1)) {
                //Si esta logeado hace la operacion y devuelve un mensaje positivo.
                if (admin != null) {
                    movieService.operationEntitie(fetchEntitiDTO);
                    return ResponseEntity.ok("Se ha realizado correctamente");
                } else{
                    // Devuelve un mensaje de error si el administrador no está autenticado.
                    return ResponseEntity.badRequest().body("Error: El administrador no está autenticado");
                }
            } else {
                // Devuelve un mensaje de error si el input no es válido para la entidad.
                return ResponseEntity.badRequest().body("Error: Entrada no válida para la entidad");
            }
        } catch (UnsupportedOperationException | MovieService.EntityNotFoundException | MovieService.entitiExist e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage()); // Manejo de excepciones especificas
        }
    }

    @PostMapping("/operationMovies")
    ResponseEntity<String> operationMovies(@RequestBody OperationMovies operationMovies){
        // Obtiene el administrador de la sesión actual.
        Administrator admin = (Administrator) session.getAttribute("admin");
        // Obtiene el título de la película del objeto OperationMovies.
        String title = operationMovies.getTitle();
        try {
            //Si el primer imput esta vacio devuelve mensaje de error
            if (movieService.inputEntitie(title)) {
                // Si el administrador está autenticado, realiza la operación en la película.
                if (admin != null) {
                    movieService.operationMovies(operationMovies);
                    return ResponseEntity.ok("Se ha realizado correctamente");
                } else{
                    // Devuelve un mensaje de error si el administrador no está autenticado.
                     return ResponseEntity.badRequest().body("Error: El administrador no está autenticado");
                }
            } else {
                // Devuelve un mensaje de error si el título no es válido para la película.
                return ResponseEntity.badRequest().body("Error: Entrada no válida para la entidad");
            }
        } catch (UnsupportedOperationException | MovieService.EntityNotFoundException | MovieService.entitiExist e) {
            // Manejo de excepciones y retorno de mensajes de error específicos.
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
