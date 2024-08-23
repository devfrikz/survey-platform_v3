package com.surveyplatform.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "login";  // Retorna la vista login.html
    }

    @GetMapping("/login-success")
    public String loginSuccess() {
        return "redirect:/index";  // Redirige manualmente al índice después del login
    }

}
