package com.surveyplatform.app.controller;

import com.surveyplatform.app.dto.Formulario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FormApprovalController {

    @GetMapping("/create-form")
    public String createForm() {
        return "form";  // Retorna la vista create-form.html
    }

    @GetMapping("/approvals")
    public String getApprovalPage(Model model) {
        // Aquí se debe obtener la lista de formularios pendientes de aprobación
        List<Formulario> formularios = obtenerFormulariosPendientes();
        model.addAttribute("formularios", formularios);
        return "approval";  // nombre del archivo HTML (approval.html)
    }

    private List<Formulario> obtenerFormulariosPendientes() {//TODO Crear service para obtener esto
        List<Formulario> formularios = new ArrayList<>();
        formularios.add(new Formulario(1, "Permission Request", "John Doe", LocalDate.now(), "Pending"));
        formularios.add(new Formulario(2, "Credit Approval", "Jane Smith", LocalDate.now().minusDays(1), "Pending"));
        return formularios;
    }
}

