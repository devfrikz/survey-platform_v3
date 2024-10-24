package com.surveyplatform.app.controller;

import com.surveyplatform.app.dto.forms.VirtualAssistanceDto;
import com.surveyplatform.app.service.forms.VirtualAssistanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import static com.surveyplatform.app.utils.Constants.FINANCE_DIRECTOR;
import static com.surveyplatform.app.utils.Constants.GENERAL_MANAGEMENT;
import static com.surveyplatform.app.utils.Constants.GENERAL_SALES_MANAGER;
import static com.surveyplatform.app.utils.Constants.INDEX;
import static com.surveyplatform.app.utils.Constants.INTERNET_SALES_MANAGER;
import static com.surveyplatform.app.utils.Constants.NEW_CAR_SALES_MANAGER;
import static com.surveyplatform.app.utils.Constants.PROMOTIONAL_EVENTS;
import static com.surveyplatform.app.utils.Constants.SALES_MANAGER_PRE_OWNED;
import static com.surveyplatform.app.utils.Constants.SHOW_CONTENT;

@Controller
@RequiredArgsConstructor
public class VirtualAssistanceController {

    private final VirtualAssistanceService virtualAssistanceService;

    @GetMapping("/general-management")
    public String generalManagement(Model model) {
        model.addAttribute(SHOW_CONTENT, GENERAL_MANAGEMENT);
        return INDEX;
    }

    @PostMapping("/submit-general-management")
    public String submitGeneralManagement(VirtualAssistanceDto virtualAssistanceDto) {
        virtualAssistanceService.submitGeneralManagement(virtualAssistanceDto);
        return INDEX;
    }

    @GetMapping("/general-sales-manager")
    public String generalSalesManager(Model model) {
        
        model.addAttribute(SHOW_CONTENT, GENERAL_SALES_MANAGER);
        return INDEX;
    }

    @PostMapping("/submit-general-sales-manager")
    public String submitGeneralSalesManager(VirtualAssistanceDto virtualAssistanceDto) {
        virtualAssistanceService.submitGeneralSalesManager(virtualAssistanceDto);
        return INDEX;
    }

    @GetMapping("/new-car-sales-manager")
    public String newCarSalesManager(Model model) {
        model.addAttribute(SHOW_CONTENT, NEW_CAR_SALES_MANAGER);
        return INDEX;
    }

    @PostMapping("/submit-new-car-sales-manager")
    public String submitNewCarSalesManager(VirtualAssistanceDto virtualAssistanceDto) {
        virtualAssistanceService.submitSalesManagerEvaluation(virtualAssistanceDto);
        return INDEX;
    }

    @GetMapping("/sales-manager-pre-owned")
    public String salesManagerPreOwned(Model model){
        model.addAttribute(SHOW_CONTENT, SALES_MANAGER_PRE_OWNED);
        return INDEX;
    }

    @PostMapping("/submit-sales-manager-pre-owned")
    public String submitSalesManagerPreOwned(VirtualAssistanceDto virtualAssistanceDto) {
        virtualAssistanceService.submitSalesManagerPreOwned(virtualAssistanceDto);
        return INDEX;
    }

    @GetMapping("/finance-director")
    public String financeDirector(Model model){
        model.addAttribute(SHOW_CONTENT, FINANCE_DIRECTOR);
        return INDEX;
    }

    @PostMapping("/submit-finance-director")
    public String submitfinanceDirector(VirtualAssistanceDto virtualAssistanceDto) {
        virtualAssistanceService.submitFinanceDirector(virtualAssistanceDto);
        return INDEX;
    }

    @GetMapping("/internet-sales-manager")
    public String internetSalesManager(Model model){
        model.addAttribute(SHOW_CONTENT, INTERNET_SALES_MANAGER);
        return INDEX;
    }

    @PostMapping("/submit-internet-sales-manager")
    public String submitInternetSalesManager(VirtualAssistanceDto virtualAssistanceDto) {
        virtualAssistanceService.submitInternetSalesManager(virtualAssistanceDto);
        return INDEX;
    }

    @GetMapping("/promotional-events")
    public String promotionalEvent(Model model){
        model.addAttribute(SHOW_CONTENT, PROMOTIONAL_EVENTS);
        return INDEX;
    }

    @PostMapping("/submit-promotional-events")
    public String submitPromotionalEvent(VirtualAssistanceDto virtualAssistanceDto) {
        virtualAssistanceService.submitPromotionalEvent(virtualAssistanceDto);
        return INDEX;
    }
}
