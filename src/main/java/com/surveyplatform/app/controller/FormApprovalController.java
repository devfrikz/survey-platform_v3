package com.surveyplatform.app.controller;

import com.surveyplatform.app.dto.FormularioDto;
import com.surveyplatform.app.service.FormApprovalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FormApprovalController {

    private final FormApprovalService formApprovalService;

    @GetMapping("/create-form")
    public String createForm() {
        return "form";  // Retorna la vista create-form.html
    }

    @GetMapping("/approvals")
    public String getApprovalPage(Model model) {
        // Aquí se debe obtener la lista de formularios pendientes de aprobación
        List<FormularioDto> formularioDtos = formApprovalService.obtenerFormulariosPendientes();
        model.addAttribute("formularios", formularioDtos);
        return "approval";  // nombre del archivo HTML (approval.html)
    }
}

