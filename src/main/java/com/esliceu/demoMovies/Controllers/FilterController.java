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
    public String loginAdmin(Model model){
        List<Movie> allMovies = movieService.getAllMovies();
        model.addAttribute("movies", allMovies);
        return "filterMovies";
    }

    @PostMapping("/filterMovies")
    public String newStudent(Model model){
        return "filterMovies";
    }

}
