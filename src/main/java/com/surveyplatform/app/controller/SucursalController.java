package com.surveyplatform.app.controller;

import com.surveyplatform.app.persistance.entities.Sucursal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SucursalController {

    @GetMapping("/sucursal")
    public String showSucursalForm(Model model) {
        model.addAttribute("sucursal", new Sucursal());
        return "formulario";
    }

    @PostMapping("/sucursal/save")
    public String saveSucursal(@ModelAttribute Sucursal sucursal) {
        // Lógica para guardar la sucursal
        return "redirect:/sucursal";
    }
}
