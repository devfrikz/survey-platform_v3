package com.surveyplatform.app.controller;

import com.surveyplatform.app.service.internal.CountryService;
import com.surveyplatform.app.service.internal.ModuleService;
import com.surveyplatform.app.service.internal.RoleService;
import com.surveyplatform.app.service.internal.SucursalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static com.surveyplatform.app.utils.Constants.SHOW_CONTENT;
import static com.surveyplatform.app.utils.Constants.USER_MANAGEMENT;

@Controller
@RequiredArgsConstructor
public class UserManagementController {

    private final SucursalService sucursalService;
    private final ModuleService moduleService;
    private final RoleService roleService;
    private final CountryService countryService;

    @GetMapping("/user-management")
    public String userManagement(Model model) {
        var sucursalList = sucursalService.findAll();
        var roleList = roleService.findAll();
        var countryList = countryService.findAll();

        model.addAttribute("sucursalList", sucursalList);
        model.addAttribute("roleList", roleList);
        model.addAttribute("countryList", countryList);

        model.addAttribute(SHOW_CONTENT, USER_MANAGEMENT);
        return "index";
    }
}
