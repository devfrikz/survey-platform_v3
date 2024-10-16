package com.surveyplatform.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/error")
    public String error() {
        return "error";  // Retorna la vista login.html
    }

}
