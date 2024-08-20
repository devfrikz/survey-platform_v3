package com.surveyplatform.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String login() {
        return "login";  // Retorna la vista login.html
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("mensaje", "¡Hola, Thymeleaf!");
        return "index";
    }

    @GetMapping("/login-success")
    public String loginSuccess() {
        return "redirect:/";  // Redirige manualmente al índice después del login
    }

    @GetMapping("/error")
    public String error() {
        return "error";  // Retorna la vista login.html
    }

    @GetMapping("/logout")
    public String logout() {
        return "login";  // Retorna la vista login.html
    }

}
