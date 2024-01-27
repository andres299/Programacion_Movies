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
        Administrator admin = (Administrator) session.getAttribute("admin");
        model.addAttribute("isAdminNotNull", admin != null);
        model.addAttribute("listOfMovies",movieService.getMovieList(page));
        return "filterMovies";
    }
    @PostMapping("/changePageMovies")
    @ResponseBody
    public List<Movie> changePageMovies(@RequestParam int page) {
        return movieService.getMovieList(page);
    }

    @PostMapping("/filterMovies")
    @ResponseBody
    public List<Movie> filterMovies(@RequestParam String filterType, @RequestParam String keyword, @RequestParam int page) {
        return movieService.filterMovies(filterType,keyword,page);
    }

    @PostMapping("/infoMovies")
    @ResponseBody
    public List<InfoMovies> infoMovies(@RequestBody Map<String, Integer> requestBody) {
        return movieService.getInfoMovies(requestBody);
    }

    @PostMapping("/operationInfoMovies")
    ResponseEntity<String> operationInfoMovies(@RequestBody FetchInfoMoviesDTO fetchInfoMoviesDTO){
        Administrator admin = (Administrator) session.getAttribute("admin");
        System.out.println(fetchInfoMoviesDTO.getGender());
        //if (admin == null){
        //  return "redirect:/filterMovies";
        //
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

}
