package com.esliceu.demoMovies.Controllers;

import com.esliceu.demoMovies.Entities.Movie;
import com.esliceu.demoMovies.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FilterController {

    @Autowired
    MovieService movieService;

    @GetMapping("/filterMovies")
    public String showMovies(Model model){
        return "filterMovies";
    }
    @GetMapping("/allMovies")
    @ResponseBody
    public List<Movie> showMovies2(){
        return movieService.getAllMovies();
    }

    /*
    @PostMapping("/filterMovies")
    public String filterMovies(Model model,
                               @RequestParam String filterType, @RequestParam String keyword){
        System.out.println(filterType + keyword);
        List<Movie> filteredMovies = movieService.filterMovies(filterType , keyword);
        if (filteredMovies != null) {
            model.addAttribute("movies", filteredMovies);
        } else {
            System.out.println("Vacio");
        }
        model.addAttribute("movies", filteredMovies);
        return "filterMovies";
    }
     */

}
