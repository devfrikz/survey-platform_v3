package com.surveyplatform.app.controller;

import com.surveyplatform.app.persistance.entities.Usuario;
import com.surveyplatform.app.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final UsuarioService usuarioService;

    private final PasswordEncoder passwordEncoder;

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
            return "redirect:/index";
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error durante la autenticación. Por favor, inténtelo de nuevo.");
            Arrays.stream(e.getStackTrace()).forEach(error -> log.error(error.toString()));
            return "login";  // Regresar al login si ocurre un error
        }

    }

    @GetMapping("/login-success")
    public String loginSuccess() {
        return "redirect:/index";
    }
}
