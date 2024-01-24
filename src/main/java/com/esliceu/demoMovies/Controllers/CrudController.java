package com.esliceu.demoMovies.Controllers;

import com.esliceu.demoMovies.DTO.FetchEntitiDTO;
import com.esliceu.demoMovies.DTO.OperationMovies;
import com.esliceu.demoMovies.Entities.Administrator;
import com.esliceu.demoMovies.Entities.Country;
import com.esliceu.demoMovies.Entities.Movie;
import com.esliceu.demoMovies.Services.AdminService;
import com.esliceu.demoMovies.Services.MovieService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CrudController {
    @Autowired
    MovieService movieService;
    @Autowired
    HttpSession session;

    @GetMapping("/crud")
    public String showCrud() {
        /*
        Administrator admin = (Administrator) session.getAttribute("admin");
        if (admin == null){
            return "redirect:/filterMovies";
        }
         */
        return "crud";
    }

    @GetMapping("/allCountrys")
    @ResponseBody
    public List<Country> showCountrys(){
        return movieService.getAllCountrys();
    }

    @PostMapping("/infoEntities")
    @ResponseBody
    public List<?> crud(@RequestParam String selectedValue){ return movieService.infoEntities(selectedValue);}

    @PostMapping("/operationEntities")
    public ResponseEntity<String> operationEntities(@RequestBody FetchEntitiDTO fetchEntitiDTO) {
        Administrator admin = (Administrator) session.getAttribute("admin");
        String input1 = fetchEntitiDTO.getInput1();
        try {
            if (movieService.inputEntitie(input1)) {
                //if (admin != null) {
                movieService.operationEntitie(fetchEntitiDTO);
                return ResponseEntity.ok("Se ha realizado correctamente");
                //} else{
                // Aquí puedes agregar un manejo específico para la excepción relacionada con el administrador
                // return ResponseEntity.badRequest().body("Error: El administrador no está autenticado");
                //}
            } else {
                return ResponseEntity.badRequest().body("Error: Entrada no válida para la entidad");
            }
        } catch (UnsupportedOperationException | MovieService.EntityNotFoundException | MovieService.entitiExist e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/searchEntities")
    @ResponseBody
    public List<?> searchEntities(@RequestBody FetchEntitiDTO fetchEntitiDTO) {
        Administrator admin = (Administrator) session.getAttribute("admin");
        //if (admin != null) {
            return movieService.searchEntities(fetchEntitiDTO);
        //}
        //return ResponseEntity.badRequest().body("Error: Entrada no válida para la entidad");
    }

    @PostMapping("/operationMovies")
    ResponseEntity<String> operationMovies(@RequestBody OperationMovies operationMovies){
        Administrator admin = (Administrator) session.getAttribute("admin");
        String title = operationMovies.getTitle();
        try {
            if (movieService.inputEntitie(title)) {
                //if (admin != null) {
                movieService.operationMovies(operationMovies);
                System.out.println("BIen");
                return ResponseEntity.ok("Se ha realizado correctamente");
                //} else{
                // Aquí puedes agregar un manejo específico para la excepción relacionada con el administrador
                // return ResponseEntity.badRequest().body("Error: El administrador no está autenticado");
                //}
            } else {
                System.out.println("Mal");
                return ResponseEntity.badRequest().body("Error: Entrada no válida para la entidad");
            }
        } catch (UnsupportedOperationException | MovieService.EntityNotFoundException | MovieService.entitiExist e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
