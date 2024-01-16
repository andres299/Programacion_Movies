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
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FilterController {

    @Autowired
    MovieService movieService;

    /*
    @GetMapping("/filterMovies")
    public String showMovies(Model model, @RequestParam(defaultValue = "0") int page){
        List<Movie> allMovies = movieService.getAllMovies();
        int pageSize = 10;
        int start = Math.toIntExact(page * pageSize);
        int end = Math.toIntExact(Math.min((page + 1) * pageSize, allMovies.size()));

        model.addAttribute("movies", allMovies.subList(start, end));
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", (int) Math.ceil((double) allMovies.size() / pageSize));
        return "filterMovies";
    }
     */
    @GetMapping("/filterMovies")
    public String showMovies(Model model){
        model.addAttribute("allMovies",movieService.getFirstMovies());
        return "filterMovies";
    }
    @GetMapping("/moviesByPage")
    @ResponseBody
    public List<Movie> showMovies2(@RequestParam int page){
        return movieService.getAllMoviesByPage(page);
    }

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

}
