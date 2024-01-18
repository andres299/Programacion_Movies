package com.esliceu.demoMovies.Controllers;

import com.esliceu.demoMovies.Entities.Country;
import com.esliceu.demoMovies.Entities.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CrudController {
    @GetMapping("/crud")
    public String showCrud(Model model){
        return "crud";
    }

    @PostMapping("/crud")
    @ResponseBody
    public List<Country> crudCOuntry(){
        return null;
    }
}
