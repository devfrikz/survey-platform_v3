package com.surveyplatform.app.controller;

import com.surveyplatform.app.dto.forms.SubmittedFormDto;
import com.surveyplatform.app.service.forms.ManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import static com.surveyplatform.app.utils.Constants.CUSTOMER_NEEDS;
import static com.surveyplatform.app.utils.Constants.DAILY_PLANNER;
import static com.surveyplatform.app.utils.Constants.DELIVERY_CHECKLIST;
import static com.surveyplatform.app.utils.Constants.END_OF_DAY;
import static com.surveyplatform.app.utils.Constants.INDEX;
import static com.surveyplatform.app.utils.Constants.SHOW_CONTENT;
import static com.surveyplatform.app.utils.Constants.SSI_1000;

@Controller
@RequiredArgsConstructor
public class ManagementController {

    private final ManagementService managementService;

    @GetMapping("/daily-planner")
    public String showDailyPlanner(Model model) {

        model.addAttribute(SHOW_CONTENT, DAILY_PLANNER);
        return INDEX;
    }

    @GetMapping("/customer-needs")
    public String showCustomerNeeds(Model model) {
        model.addAttribute(SHOW_CONTENT, CUSTOMER_NEEDS);
        return INDEX;
    }

    @GetMapping("/ssi-1000")
    public String showSSi1000(Model model) {
        model.addAttribute(SHOW_CONTENT, SSI_1000);
        return INDEX;
    }

    @GetMapping("/delivery-checklist")
    public String showDeliveryChecklist(Model model) {
        model.addAttribute(SHOW_CONTENT, DELIVERY_CHECKLIST);
        return INDEX;
    }

    @GetMapping("/end-of-day")
    public String showEndOfDay(Model model) {
        model.addAttribute(SHOW_CONTENT, END_OF_DAY);
        return INDEX;
    }

    @PostMapping("/submit-daily-planner")
    public String submitDailyPlanner(SubmittedFormDto submittedFormDto, Model model) {
        managementService.submitDailyPlanner(submittedFormDto);

        model.addAttribute(SHOW_CONTENT, DAILY_PLANNER);
        return INDEX;
    }

    @PostMapping("/submit-customer-needs")
    public String submitCustomerNeeds(SubmittedFormDto submittedFormDto, Model model) {
        managementService.submitCustomerNeeds(submittedFormDto);

        model.addAttribute(SHOW_CONTENT, CUSTOMER_NEEDS);
        return INDEX;
    }

    @PostMapping("/submit-delivery-checklist")
    public String submitDeliveryChecklist(SubmittedFormDto submittedFormDto, Model model) {
        managementService.submitDeliveryChecklist(submittedFormDto);

        model.addAttribute(SHOW_CONTENT, DELIVERY_CHECKLIST);
        return INDEX;
    }

    @PostMapping("/submit-end-of-day")
    public String submitEndOfDay(SubmittedFormDto submittedFormDto, Model model) {
        managementService.submitEndOfDay(submittedFormDto);

        model.addAttribute(SHOW_CONTENT, END_OF_DAY);
        return INDEX;
    }

    @PostMapping("/submit-ssi-1000")
    public String submitSSi1000(SubmittedFormDto submittedFormDto, Model model) {
        managementService.submitSSi1000(submittedFormDto);

        model.addAttribute(SHOW_CONTENT, SSI_1000);
        return INDEX;
    }
}
