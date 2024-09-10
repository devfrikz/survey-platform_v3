package com.surveyplatform.app.controller;

import com.surveyplatform.app.dto.SubmittedFormDto;
import com.surveyplatform.app.service.ManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ManagementController {

    private final ManagementService managementService;

    @GetMapping("/daily-planner")
    public String showDailyPlanner() {
        return "daily-planner";
    }

    @GetMapping("/customer-needs")
    public String showCustomerNeeds() {
        return "customer-needs";
    }

    @GetMapping("/ssi-1000")
    public String showSSi1000() {
        return "ssi-1000";
    }

    @GetMapping("/delivery-checklist")
    public String showDeliveryChecklist() {
        return "delivery-checklist";
    }

    @GetMapping("/end-of-day")
    public String showEndOfDay() {
        return "end-of-day";
    }

    @PostMapping("/submit-daily-planner")
    public String submitDailyPlanner(SubmittedFormDto submittedFormDto, Model model) {
        managementService.submitDailyPlanner(submittedFormDto);
        return "daily-planner";
    }

    @PostMapping("/submit-customer-needs")
    public String submitCustomerNeeds(SubmittedFormDto submittedFormDto, Model model) {
        managementService.submitCustomerNeeds(submittedFormDto);
        return "customer-needs";
    }

    @PostMapping("/submit-delivery-checklist")
    public String submitDeliveryChecklist(SubmittedFormDto submittedFormDto, Model model) {
        managementService.submitDeliveryChecklist(submittedFormDto);
        return "delivery-checklist";
    }

    @PostMapping("/submit-end-of-day")
    public String submitEndOfDay(SubmittedFormDto submittedFormDto, Model model) {
        managementService.submitEndOfDay(submittedFormDto);
        return "end-of-day";
    }

    @PostMapping("/submit-ssi-1000")
    public String submitSSi1000(SubmittedFormDto submittedFormDto, Model model) {
        managementService.submitSSi1000(submittedFormDto);
        return "ssi-1000";
    }
}
