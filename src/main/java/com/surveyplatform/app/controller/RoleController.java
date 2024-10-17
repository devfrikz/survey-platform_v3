package com.surveyplatform.app.controller;

import com.surveyplatform.app.dto.internal.RoleDto;
import com.surveyplatform.app.service.internal.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;
    @PostMapping("/role/save")
    public String saveRole(RoleDto role, Model model) {
        roleService.saveRole(role);
        return "redirect:/user-management";
    }
}
