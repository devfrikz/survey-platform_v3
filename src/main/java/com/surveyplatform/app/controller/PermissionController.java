package com.surveyplatform.app.controller;

import com.surveyplatform.app.dto.internal.PermisoDto;
import com.surveyplatform.app.service.internal.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;
    @PostMapping("/permission/save")
    public String save(PermisoDto role, Model model) {
        permissionService.save(role);
        return "redirect:/user-management";
    }
}
