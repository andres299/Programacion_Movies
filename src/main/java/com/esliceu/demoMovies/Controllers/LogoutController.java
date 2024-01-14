package com.esliceu.demoMovies.Controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
    @Autowired
    HttpSession session;

    @GetMapping("/Logout")
    public String Logout() {
        // Invalidar la sesion existente
        if (session != null) {
            session.invalidate();
        }
        // Redirirgir a login
        return "redirect:/loginAdmin";
    }
}

