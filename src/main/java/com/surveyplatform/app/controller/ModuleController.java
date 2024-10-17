package com.surveyplatform.app.controller;

import com.surveyplatform.app.dto.internal.ModuleDto;
import com.surveyplatform.app.service.internal.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ModuleController {

    private final ModuleService moduleService;
    @PostMapping("/module/save")
    public String save(ModuleDto moduleDto, Model model) {
        moduleService.save(moduleDto);
        return "redirect:/user-management";
    }
}
