package com.surveyplatform.app.controller;

import com.surveyplatform.app.dto.SubmittedFormDto;
import com.surveyplatform.app.exception.SurveyPlatformException;
import com.surveyplatform.app.service.FormApprovalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class FormApprovalController {

    private final FormApprovalService formApprovalService;

    @GetMapping("/create-form")
    public String createForm() {
        return "form";  // Retorna la vista create-form.html
    }

    @GetMapping("/approvals")
    public String getApprovalPage(Model model,
                                  @RequestParam(name = "size", defaultValue = "5") int size,
                                  @RequestParam(name = "page", defaultValue = "0") int page) {
        try {
            var pageable = Pageable.ofSize(size).withPage(page);
            var formularioPage = formApprovalService.getPendingFormsBySucursalAndRol(pageable);

            // Añadir los formularios filtrados al modelo para ser mostrados en la vista
            model.addAttribute("formularios", formularioPage.getContent());
            model.addAttribute("currentPage", formularioPage.getNumber());
            model.addAttribute("totalPages", formularioPage.getTotalPages());
            model.addAttribute("size", size);

            return "approval";
        } catch (SurveyPlatformException e) {
            throw new SurveyPlatformException(e.getMessage(), e.getCode());
        }
    }

    @PostMapping("/add-form")
    public String addForm(SubmittedFormDto submittedFormDto) {
        formApprovalService.addForm(submittedFormDto);
        return "form";
    }
}
