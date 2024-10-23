package com.surveyplatform.app.controller;

import com.surveyplatform.app.dto.forms.SubmittedFormDto;
import com.surveyplatform.app.exception.SurveyPlatformException;
import com.surveyplatform.app.service.forms.FormApprovalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.surveyplatform.app.utils.Constants.APPROVALS;
import static com.surveyplatform.app.utils.Constants.INDEX;
import static com.surveyplatform.app.utils.Constants.SALE_FORM;
import static com.surveyplatform.app.utils.Constants.SHOW_CONTENT;

@Controller
@RequiredArgsConstructor
public class FormApprovalController {

    private final FormApprovalService formApprovalService;
    @GetMapping("/create-form")
    public String createForm(Model model) {

        model.addAttribute(SHOW_CONTENT, SALE_FORM);
        return INDEX;
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

            model.addAttribute(SHOW_CONTENT, APPROVALS);
            return INDEX;
        } catch (SurveyPlatformException e) {
            throw new SurveyPlatformException(e.getMessage(), e.getCode());
        }
    }

    @PostMapping("/add-form")
    public String addForm(SubmittedFormDto submittedFormDto, Model model) {
        formApprovalService.addForm(submittedFormDto);
        model.addAttribute(SHOW_CONTENT, SALE_FORM);
        return INDEX;
    }

    @PostMapping("/approve-form")
    public String approveForm(@RequestParam("formId") Long formId) {
        formApprovalService.approveForm(formId);
        return "redirect:/approvals";
    }

    @PostMapping("/reject-form")
    public String rejectForm(@RequestParam("formId") Long formId) {
        formApprovalService.rejectForm(formId);
        return "redirect:/approvals";
    }
}
