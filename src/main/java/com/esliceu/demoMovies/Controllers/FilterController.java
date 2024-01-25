package com.esliceu.demoMovies.Controllers;

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
    public String showMovies(Model model){
        Administrator admin = (Administrator) session.getAttribute("admin");
        model.addAttribute("isAdminNotNull", admin != null);
        return "filterMovies";
    }
    @GetMapping("/allMovies")
    @ResponseBody
    public List<Movie> showMovies(){
        return movieService.getAllMovies();
    }


    @PostMapping("/filterMovies")
    @ResponseBody
    public List<Movie> filterMovies(@RequestParam String filterType, @RequestParam String keyword) {
        return movieService.filterMovies(filterType,keyword);
    }

    @PostMapping("/infoMovies")
    public List<InfoMovies> infoMovies(@RequestBody Map<String, Integer> requestBody) {
        return movieService.getInfoMovies(requestBody);
    }

}
