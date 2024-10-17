package com.surveyplatform.app.controller;

import com.surveyplatform.app.dto.internal.UserDto;
import com.surveyplatform.app.service.internal.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/save")
    public String save(UserDto userDto, Model model) {
        userService.save(userDto);
        return "redirect:/user-management";
    }
}
