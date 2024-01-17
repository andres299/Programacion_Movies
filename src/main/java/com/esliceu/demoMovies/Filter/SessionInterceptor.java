package com.esliceu.demoMovies.Filter;

import com.esliceu.demoMovies.Entities.Administrator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class SessionInterceptor implements HandlerInterceptor {
    @Autowired
    HttpSession session;
    @Override
    public boolean preHandle(
            HttpServletRequest req,
            HttpServletResponse resp,
            Object handler) throws Exception{
        // Obtenemos el usuario actual
        Administrator admin = (Administrator) session.getAttribute("admin");
        // Agregar el usuario al atributo.
        req.setAttribute("admin", admin);
        // Verificar si el usuario está autenticado.
        if (admin == null) {
            // Redirigir a la página de inicio de sesión si no está autenticado.
            resp.sendRedirect("/loginAdmin");
            return false;
        }
        // Continuar con la ejecución del controlador actual
        return true;
    }
}
