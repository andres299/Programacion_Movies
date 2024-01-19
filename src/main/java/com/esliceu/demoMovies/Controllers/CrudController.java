package com.esliceu.demoMovies.Controllers;

import com.esliceu.demoMovies.Entities.Country;
import com.esliceu.demoMovies.Entities.Movie;
import com.esliceu.demoMovies.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CrudController {
    @Autowired
    MovieService movieService;
    @GetMapping("/crud")
    public String showCrud(Model model){
        return "crud";
    }

    @GetMapping("/allCountrys")
    @ResponseBody
    public List<Country> showCountrys(){
        return movieService.getAllCountrys();
    }

    @PostMapping("/infoEntities")
    @ResponseBody
    public List<?> crud(@RequestParam String selectedValue){
        return movieService.infoEntities(selectedValue);
    }
}
