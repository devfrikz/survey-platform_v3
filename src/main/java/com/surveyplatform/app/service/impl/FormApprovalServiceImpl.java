package com.surveyplatform.app.service.impl;

import com.surveyplatform.app.dto.FormularioDto;
import com.surveyplatform.app.dto.SubmittedFormDto;
import com.surveyplatform.app.mapper.FormApprovalMapper;
import com.surveyplatform.app.persistance.entities.Formulario;
import com.surveyplatform.app.persistance.entities.FormularioRespuesta;
import com.surveyplatform.app.persistance.repository.FormApprovalRepository;
import com.surveyplatform.app.persistance.repository.FormRepository;
import com.surveyplatform.app.persistance.repository.FormTypeRepository;
import com.surveyplatform.app.persistance.repository.ModuleRepository;
import com.surveyplatform.app.persistance.repository.SucursalRepository;
import com.surveyplatform.app.service.FormApprovalService;
import com.surveyplatform.app.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
@Slf4j
public class FormApprovalServiceImpl implements FormApprovalService {
    private final SucursalRepository sucursalRepository;
    private final FormRepository formRepository;
    private final FormApprovalRepository formApprovalRepository;
    private final ModuleRepository moduleRepository;
    private final FormTypeRepository formTypeRepository;

    private final UsuarioService userService;

    public Page<FormularioDto> getPendingForms(Pageable pageable) {
        var forms = formApprovalRepository.findAll(pageable);
        var list = forms.getContent().stream().map(FormApprovalMapper.MAPPER::toDto).toList();

        return new PageImpl<>(list, pageable, forms.getTotalElements());
    }

    public void addForm(SubmittedFormDto submittedFormDto) {
        var loggedUser = userService.getLoggedUser();

        var user = userService.findByEmail(loggedUser).orElseThrow();
        var sucursal = sucursalRepository.findById(user.getSucursalId()).orElseThrow();

        var formType = formTypeRepository.findByTipoIgnoreCase(submittedFormDto.getFormType()).orElseThrow();

        var module = moduleRepository.findById(1L).orElseThrow();//TODO ver de donde obtener el modulo

        var form = Formulario.builder()
                .nombre(formType.getDescripcion())
                .descripcion(submittedFormDto.getFormType())
                .modulo(module)
                .tipo(formType)
                .build();

        var formSaved = formRepository.save(form);

        var formularioRespuesta = FormularioRespuesta.builder()
                .formulario(formSaved)
                .usuario(user)
                .sucursal(sucursal)
                .datos("")//TODO chequear para que es este campo
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .updatedAt(new Timestamp(System.currentTimeMillis()))
                .build();

        switch (submittedFormDto.getFormType()) {//TODO tratar formularios por tipo
            case "permiso" -> log.info("Guardando formulario de permiso");
            case "credito" -> log.info("Guardando formulario de crédito");
            case "descuento" -> log.info("Guardando formulario de descuento");
            case "referral" -> log.info("Guardando formulario de referido");
            default -> {
                var message = "Tipo de formulario no soportado: " + submittedFormDto.getFormType();
                throw new IllegalArgumentException(message);
            }
        }

        // Mapea el DTO a la entidad y guarda en la base de datos
        formApprovalRepository.save(formularioRespuesta);
        log.info("Formulario guardado: {}", formularioRespuesta.getId());
    }
}
