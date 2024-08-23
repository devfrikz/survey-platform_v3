package com.surveyplatform.app.controller;

import com.surveyplatform.app.persistance.entities.Usuario;
import com.surveyplatform.app.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String usernameOrEmail,
                        @RequestParam("password") String password,
                        Model model) {

        try {
            Optional<Usuario> usuarioOpt = usuarioService.findByUsernameOrEmail(usernameOrEmail);
            if (usuarioOpt.isPresent()) {
                Usuario usuario = usuarioOpt.get();
                if (passwordEncoder.matches(password, usuario.getPassword())) {
                    return "redirect:/index";
                } else {
                    model.addAttribute("error", "Contraseña incorrecta");
                }
            } else {
                model.addAttribute("error", "Usuario no encontrado");
            }
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error durante la autenticación. Por favor, inténtelo de nuevo.");
        }

        return "login";
    }

    @GetMapping("/index")
    public String showIndex(Model model) {
        model.addAttribute("mensaje", "¡Hola, Thymeleaf!");
        return "index";
    }

    @GetMapping("/login-success")
    public String loginSuccess() {
        return "redirect:/index";  // Redirige manualmente al índice después del login
    }

    @GetMapping("/error")
    public String error() {
        return "error";  // Retorna la vista error.html
    }
}
