package com.esliceu.demoMovies.Controllers;

import com.esliceu.demoMovies.Entities.Administrator;
import com.esliceu.demoMovies.Entities.Movie;
import com.esliceu.demoMovies.Services.AdminService;
import com.esliceu.demoMovies.Services.MovieService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FilterController {

    @Autowired
    MovieService movieService;

    @GetMapping("/filterMovies")
    public String showrMovies(Model model){
        List<Movie> allMovies = movieService.getAllMovies();
        model.addAttribute("movies", allMovies);
        return "filterMovies";
    }

    @PostMapping("/filterMovies")
    public String filterMovies(Model model,
                               @RequestParam String filterType, @RequestParam String keyword){
        List<Movie> filteredMovies = movieService.filterMovies(filterType , keyword);
        System.out.println(filterType + keyword);
        if (filteredMovies != null) {
            model.addAttribute("movies", filteredMovies);
        } else {
            System.out.println("Vacio");
        }
        model.addAttribute("movies", filteredMovies);
        return "filterMovies";
    }

}
