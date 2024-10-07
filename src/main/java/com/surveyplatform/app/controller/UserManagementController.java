package com.surveyplatform.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserManagementController {
    @GetMapping("/user-management")
    public String userManagement() {
        return "modules/users-managements";
    }
}
