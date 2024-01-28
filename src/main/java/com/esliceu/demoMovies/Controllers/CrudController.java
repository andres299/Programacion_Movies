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
        Administrator admin = (Administrator) session.getAttribute("admin");
        if (admin == null) {
            return "redirect:/filterMovies";
        }
        List<Country> country = countryService.getAllCountrys(page);
        model.addAttribute("listCountries", countryService.getAllCountrys(page));
        return "crud";
    }

    @PostMapping("/infoEntities")
    @ResponseBody
    public List<?> crud(@RequestParam String selectedValue,@RequestParam int page){
        return movieService.infoEntities(selectedValue,page);}

    @PostMapping("/searchEntities")
    @ResponseBody
    public List<?> searchEntities(@RequestBody FetchEntitiDTO fetchEntitiDTO) {
            return movieService.searchEntities(fetchEntitiDTO);
    }

    @PostMapping("/operationEntities")
    public ResponseEntity<String> operationEntities(@RequestBody FetchEntitiDTO fetchEntitiDTO) {
        Administrator admin = (Administrator) session.getAttribute("admin");
        String input1 = fetchEntitiDTO.getInput1();
        try {
            //Si el primer imput esta vacio devuelve mensaje de error
            if (movieService.inputEntitie(input1)) {
                //Si esta logeado hace la operacion
                if (admin != null) {
                    movieService.operationEntitie(fetchEntitiDTO);
                    return ResponseEntity.ok("Se ha realizado correctamente");
                } else{
                // Aquí agrego manejo específico para la excepción relacionada con el administrador
                    return ResponseEntity.badRequest().body("Error: El administrador no está autenticado");
                }
            } else {
                return ResponseEntity.badRequest().body("Error: Entrada no válida para la entidad");
            }
        } catch (UnsupportedOperationException | MovieService.EntityNotFoundException | MovieService.entitiExist e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/operationMovies")
    ResponseEntity<String> operationMovies(@RequestBody OperationMovies operationMovies){
        Administrator admin = (Administrator) session.getAttribute("admin");
        String title = operationMovies.getTitle();
        try {
            //Si el primer imput esta vacio devuelve mensaje de error
            if (movieService.inputEntitie(title)) {
                //Si esta logeado hace la operacion
                if (admin != null) {
                    movieService.operationMovies(operationMovies);
                    return ResponseEntity.ok("Se ha realizado correctamente");
                } else{
                // Aquí agrego un manejo específico para la excepción relacionada con el administrador
                     return ResponseEntity.badRequest().body("Error: El administrador no está autenticado");
                }
            } else {
                return ResponseEntity.badRequest().body("Error: Entrada no válida para la entidad");
            }
        } catch (UnsupportedOperationException | MovieService.EntityNotFoundException | MovieService.entitiExist e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
