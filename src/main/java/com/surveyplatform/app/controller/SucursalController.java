package com.surveyplatform.app.controller;

import com.surveyplatform.app.dto.internal.SucursalDto;
import com.surveyplatform.app.service.internal.SucursalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SucursalController {

    private final SucursalService sucursalService;

    @PostMapping("/sucursal/save")
    public String saveSucursal(SucursalDto sucursal, Model model) {
        sucursalService.saveSucursal(sucursal);
        return "redirect:/user-management";
    }
}
