package com.surveyplatform.app.controller;

import com.surveyplatform.app.dto.VirtualAssistanceDto;
import com.surveyplatform.app.service.VirtualAssistanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class VirtualAssistanceController {

    private final VirtualAssistanceService virtualAssistanceService;

    @GetMapping("/general-management")
    public String generalManagement() {
        return "general-management";
    }

    @PostMapping("/submit-general-management")
    public String submitGeneralManagement(VirtualAssistanceDto virtualAssistanceDto, Model model) {
        virtualAssistanceService.submitGeneralManagement(virtualAssistanceDto);
        return "general-management";
    }

    @GetMapping("/general-sales-manager")
    public String generalSalesManager() {
        return "general-sales-manager";
    }

    @PostMapping("/submit-general-sales-manager")
    public String submitGeneralSalesManager(VirtualAssistanceDto virtualAssistanceDto, Model model) {
        virtualAssistanceService.submitGeneralSalesManager(virtualAssistanceDto);
        return "general-sales-manager";
    }

    @GetMapping("/new-car-sales-manager")
    public String newCarSalesManager() {
        return "new-car-sales-manager";
    }

    @PostMapping("/submit-new-car-sales-manager")
    public String submitNewCarSalesManager(VirtualAssistanceDto virtualAssistanceDto, Model model) {
        virtualAssistanceService.submitSalesManagerEvaluation(virtualAssistanceDto);
        return "new-car-sales-manager";
    }

    @GetMapping("/sales-manager-pre-owned")
    public String salesManagerPreOwned() {
        return "sales-manager-pre-owned";
    }

    @PostMapping("/submit-sales-manager-pre-owned")
    public String submitSalesManagerPreOwned(VirtualAssistanceDto virtualAssistanceDto, Model model) {
        virtualAssistanceService.submitSalesManagerPreOwned(virtualAssistanceDto);
        return "sales-manager-pre-owned";
    }
}
