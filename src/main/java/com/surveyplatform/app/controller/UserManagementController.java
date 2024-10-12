package com.surveyplatform.app.controller;

import com.surveyplatform.app.service.ModuleService;
import com.surveyplatform.app.service.RoleService;
import com.surveyplatform.app.service.SucursalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserManagementController {

    private final SucursalService sucursalService;
    private final ModuleService moduleService;
    private final RoleService roleService;

    @GetMapping("/user-management")
    public String userManagement(Model model) {
        var sucursalList = sucursalService.findAll();
//        var moduleList = moduleService.findAll();
        var roleList = roleService.findAll();

        model.addAttribute("sucursalList", sucursalList);
//        model.addAttribute("moduleList", moduleList);
        model.addAttribute("roleList", roleList);

        return "modules/users-managements";
    }
}
