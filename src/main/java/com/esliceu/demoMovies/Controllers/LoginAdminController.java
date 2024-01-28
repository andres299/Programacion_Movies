package com.esliceu.demoMovies.Controllers;

import com.esliceu.demoMovies.Services.AdminService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginAdminController {
    @Autowired
    HttpSession session;
    @Autowired
    AdminService adminService;
    @GetMapping("/loginAdmin")
    public String loginAdmin(){
        return "loginAdmin";
    }

    @PostMapping("/loginAdmin")
    public String postloginAdmin(Model model ,
                             @RequestParam String username, @RequestParam String password){
        //Metodo para iniciar sesion, si se ha iniciado correctamente.
        if (adminService.adminExists(username, password)) {
            session.setAttribute("admin", adminService.admin(username));
            return "redirect:/filterMovies";
        }
        //Si no se ha iniciado correctamente sale el error.
        model.addAttribute("error", "El usuario o la contraseña incorrectos.");
        return "loginAdmin";
    }

}
