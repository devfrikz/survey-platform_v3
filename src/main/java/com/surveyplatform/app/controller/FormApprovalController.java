package com.surveyplatform.app.controller;

import com.surveyplatform.app.dto.SubmittedFormDto;
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

    @PostMapping("/add-form")
    public String addForm(SubmittedFormDto submittedFormDto, Model model) {
        formApprovalService.addForm(submittedFormDto);
        return "form";  // Retorna la vista add-form.html
    }

    @GetMapping("/approvals")
    public String getApprovalPage(Model model,
                                  @RequestParam(name = "size", defaultValue = "10") int size,
                                  @RequestParam(name = "page", defaultValue = "0") int page) {
        var pageable = Pageable.ofSize(size).withPage(page);
        var formularioPage = formApprovalService.getPendingForms(pageable);

        model.addAttribute("formularios", formularioPage.getContent());
        model.addAttribute("currentPage", formularioPage.getNumber());
        model.addAttribute("totalPages", formularioPage.getTotalPages());
        model.addAttribute("size", size);

        return "approval";
    }

}

