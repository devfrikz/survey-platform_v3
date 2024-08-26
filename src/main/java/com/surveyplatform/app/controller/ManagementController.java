package com.surveyplatform.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ManagementController {

    @GetMapping("/daily-planner")
    public String showDailyPlanner() {
        return "daily-planner";
    }

    @GetMapping("/customer-needs")
    public String showCustomerNeeds() {
        return "customer-needs";
    }

    @GetMapping("/ssi-1000")
    public String  showSSi1000() {
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
    public String submitDailyPlanner() {
        //TODO implement
        return "daily-planner";
    }

    @PostMapping("/submit-customer-needs")
    public String submitCustomerNeeds() {
        //TODO implement
        return "customer-needs";
    }

    @PostMapping("/submit-ssi-1000")
    public String submitSSi1000() {
        //TODO implement
        return "ssi-1000";
    }

    @PostMapping("/submit-delivery-checklist")
    public String submitDeliveryChecklist() {
        //TODO implement
        return "delivery-checklist";
    }

    @PostMapping("/submit-end-of-day")
    public String submitEndOfDay() {
        //TODO implement
        return "end-of-day";
    }
}
