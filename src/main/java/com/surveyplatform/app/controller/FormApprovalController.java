package com.surveyplatform.app.controller;

import com.surveyplatform.app.dto.SubmittedFormDto;
import com.surveyplatform.app.persistance.entities.Usuario;
import com.surveyplatform.app.service.FormApprovalService;
import com.surveyplatform.app.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.surveyplatform.app.persistance.entities.Rol;


import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class FormApprovalController {

    private final FormApprovalService formApprovalService;
    private final UsuarioService usuarioService;  // Servicio para obtener el usuario autenticado

    @GetMapping("/create-form")
    public String createForm() {
        return "form";  // Retorna la vista create-form.html
    }

    @GetMapping("/approvals")
    public String getApprovalPage(Model model,
                                  @RequestParam(name = "size", defaultValue = "5") int size,
                                  @RequestParam(name = "page", defaultValue = "0") int page) {
        String username = usuarioService.getLoggedUser();  // Obtener el usuario autenticado
        Optional<Usuario> userOpt = usuarioService.findByUsername(username);

        if (userOpt.isPresent()) {
            Usuario user = userOpt.get();
            var pageable = Pageable.ofSize(size).withPage(page);

            // Convertir los roles a una lista de IDs de tipo Long
            var roleIds = user.getRoles().stream()
                    .map(Rol::getId)  // Asegúrate de que los IDs sean de tipo Long
                    .collect(Collectors.toList());

            // Llamar al servicio con los argumentos correctos
            var formularioPage = formApprovalService.getPendingFormsBySucursalAndRol(pageable, Long.valueOf(user.getSucursal().getId()), roleIds);



            // Añadir los formularios filtrados al modelo para ser mostrados en la vista
            model.addAttribute("formularios", formularioPage.getContent());
            model.addAttribute("currentPage", formularioPage.getNumber());
            model.addAttribute("totalPages", formularioPage.getTotalPages());
            model.addAttribute("size", size);

            return "approval";  // Retorna la vista approval.html
        }

        // Si no hay usuario autenticado o hay algún error, redirigir a la página de error
        return "error";
    }


    @PostMapping("/add-form")
    public String addForm(SubmittedFormDto submittedFormDto, Model model) {
        formApprovalService.addForm(submittedFormDto);
        return "form";
    }
}
