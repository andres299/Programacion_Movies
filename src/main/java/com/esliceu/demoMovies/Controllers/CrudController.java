package com.esliceu.demoMovies.Controllers;

import com.esliceu.demoMovies.DTO.FetchEntitiDTO;
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
    public ResponseEntity<String> insertEntities(@RequestBody FetchEntitiDTO fetchEntitiDTO) {
        Administrator admin = (Administrator) session.getAttribute("admin");
        String operation = fetchEntitiDTO.getOperation();
        String entity = fetchEntitiDTO.getEntity();
        String id = fetchEntitiDTO.getId();
        String input1 = fetchEntitiDTO.getInput1();
        String input2 = fetchEntitiDTO.getInput2();
        System.out.println(operation + entity + id + input1 + input2);
        if (movieService.inputEntitie(input1)) {
            //if (admin != null) {
            movieService.operationEntitie(operation, entity, id, input1, input2);
            return ResponseEntity.ok("Se ha realizado correctamente");
            //} else{

            //}
        } else {
            System.out.println("Hola");
            return ResponseEntity.badRequest().body("Error: No se ha podido realizar la operacion");
        }
        //return null;
    }
}
