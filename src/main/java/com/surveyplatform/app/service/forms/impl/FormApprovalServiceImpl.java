package com.surveyplatform.app.service.forms.impl;

import com.surveyplatform.app.dto.forms.FormularioDto;
import com.surveyplatform.app.dto.forms.SubmittedFormDto;
import com.surveyplatform.app.exception.SurveyPlatformException;
import com.surveyplatform.app.mapper.FormApprovalMapper;
import com.surveyplatform.app.persistance.entities.forms.Formulario;
import com.surveyplatform.app.persistance.entities.forms.FormularioCredito;
import com.surveyplatform.app.persistance.entities.forms.FormularioDescuento;
import com.surveyplatform.app.persistance.entities.forms.FormularioPermiso;
import com.surveyplatform.app.persistance.entities.forms.FormularioReferenciado;
import com.surveyplatform.app.persistance.entities.forms.FormularioRespuesta;
import com.surveyplatform.app.persistance.entities.internal.manytomany.UsuarioRol;
import com.surveyplatform.app.persistance.repository.forms.FormularioCreditoRepository;
import com.surveyplatform.app.persistance.repository.forms.FormularioDescuentoRepository;
import com.surveyplatform.app.persistance.repository.forms.FormularioPermisoRepository;
import com.surveyplatform.app.persistance.repository.forms.FormularioReferenciadoRepository;
import com.surveyplatform.app.persistance.repository.forms.FormularioRepository;
import com.surveyplatform.app.persistance.repository.forms.FormularioRespuestaRepository;
import com.surveyplatform.app.persistance.repository.forms.FormularioTipoRepository;
import com.surveyplatform.app.persistance.repository.internal.ModuleRepository;
import com.surveyplatform.app.persistance.repository.internal.UserRepository;
import com.surveyplatform.app.persistance.repository.internal.UsuarioRolRepository;
import com.surveyplatform.app.service.forms.FormApprovalService;
import com.surveyplatform.app.service.internal.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@Slf4j
public class FormApprovalServiceImpl implements FormApprovalService {

    private final FormularioReferenciadoRepository formularioReferenciadoRepository;
    private final ModuleRepository moduleRepository;
    private final FormularioRepository formularioRepository;
    private final FormularioTipoRepository formularioTipoRepository;
    private final FormularioRespuestaRepository formularioRespuestaRepository;
    private final FormularioDescuentoRepository formularioDescuentoRepository;
    private final FormularioCreditoRepository formularioCreditoRepository;
    private final FormularioPermisoRepository formularioPermisoRepository;
    private final UserRepository userRepository;
    private final UsuarioRolRepository usuarioRolRepository;

    private final UserService userService;

    @Override
    public Page<FormularioDto> getPendingFormsBySucursalAndRol(Pageable pageable) {
        var username = userService.getLoggedUser().getUsername();
        var userOpt = userRepository.findByUsername(username);

        if (userOpt.isPresent()) {
            var user = userOpt.get();
            var userRoleIdList = usuarioRolRepository.findAllByUsuarioId(user.getId());
            var userRoleList = userRoleIdList.stream().map(UsuarioRol::getRolId).toList();

            try {
                var formularioRespuestas = formularioRespuestaRepository.findBySucursalIdAndRoleIds(Long.valueOf(user.getSucursal().getId()), userRoleList, pageable);
                var list = new ArrayList<FormularioDto>();

                formularioRespuestas.getContent().forEach(formularioRespuesta -> {
                    var formDto = FormApprovalMapper.MAPPER.toDto(formularioRespuesta);
                    formDto.setEmpleado(user.getNombreCompleto());
                    list.add(formDto);
                });


                return new PageImpl<>(list, pageable, formularioRespuestas.getTotalElements());
            } catch (Exception e) {
                throw new SurveyPlatformException("Error al obtener los formularios", 500);
            }
        }

        throw new SurveyPlatformException("Usuario no encontrado", 404);
    }

    @Transactional
    public void addForm(SubmittedFormDto submittedFormDto) {
        var loggedUser = userService.getLoggedUser().getUsername();

        var user = userRepository.findByEmail(loggedUser)
                .orElseThrow(() -> new SurveyPlatformException("Usuario no encontrado", 404));

        var sucursal = user.getSucursal();

        if (sucursal == null) {
            throw new SurveyPlatformException("Sucursal no encontrada para el usuario", 404);
        }

        var formType = formularioTipoRepository.findByTipoIgnoreCase(submittedFormDto.getFormType())
                .orElseThrow(() -> new SurveyPlatformException("Tipo de formulario no encontrado", 404));

        var module = moduleRepository.findById(1L)
                .orElseThrow(() -> new SurveyPlatformException("Modulo no encontrado", 404)); // TODO: Ver de dónde obtener el módulo

        var form = Formulario.builder()
                .nombre(formType.getDescripcion())
                .descripcion(submittedFormDto.getFormType())
                .modulo(module)
                .tipo(formType)
                .usuario(user)
                .build();

        var formSaved = formularioRepository.save(form);

        var formularioRespuesta = FormularioRespuesta.builder()
                .formulario(formSaved)
                .usuario(user.getId())
                .sucursal(sucursal)
                .datos("") // TODO: Chequear para qué es este campo
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .updatedAt(new Timestamp(System.currentTimeMillis()))
                .build();

        switch (submittedFormDto.getFormType()) {
            case "permiso" -> {
                var formularioPermiso = FormularioPermiso.builder()
                        .formulario(formSaved)
                        .duracionDias(submittedFormDto.getPermisoDuracion())
                        .fechaInicio(LocalDate.parse(submittedFormDto.getPermisoFecha()))
                        .build();
                formularioPermisoRepository.save(formularioPermiso);
                log.info("Guardando formulario de permiso para el usuario: {}", user.getNombreCompleto());
            }
            case "credito" -> {
                var formularioCredito = FormularioCredito.builder()
                        .formulario(formSaved)
                        .montoCredito(submittedFormDto.getCreditoAmount())
                        .nombreCliente(submittedFormDto.getCreditoCliente())
                        .build();
                formularioCreditoRepository.save(formularioCredito);
                log.info("Guardando formulario de crédito para el cliente: {}", submittedFormDto.getCreditoCliente());
            }
            case "descuento" -> {
                var formularioDescuento = FormularioDescuento.builder()
                        .formulario(formSaved)
                        .porcentajeDescuento(submittedFormDto.getDescuentoPorcentaje())
                        .razonDescuento(submittedFormDto.getDescuentoRazon())
                        .build();
                formularioDescuentoRepository.save(formularioDescuento);
                log.info("Guardando formulario de descuento");
            }
            case "referenciado" -> {
                var formularioReferido = FormularioReferenciado.builder()
                        .formulario(formSaved)
                        .nombreClienteReferido(submittedFormDto.getNombreClienteReferenciado())
                        .correoCliente(submittedFormDto.getEmailClienteReferenciado())
                        .build();
                formularioReferenciadoRepository.save(formularioReferido);
                log.info("Guardando formulario de cliente referido: {}", submittedFormDto.getNombreClienteReferenciado());
            }
            default -> {
                var message = "Tipo de formulario no soportado: " + submittedFormDto.getFormType();
                throw new SurveyPlatformException(message, 400);
            }
        }

        formularioRespuestaRepository.save(formularioRespuesta);
        log.info("Formulario guardado con ID: {}", formularioRespuesta.getId());
    }

    @Override
    public void approveForm(Long formId) {
        var formRespuesta = formularioRespuestaRepository.findById(formId)
                .orElseThrow(() -> new SurveyPlatformException("Formulario no encontrado", 404));

        formRespuesta.setAprobado(true);
        formularioRespuestaRepository.save(formRespuesta);
    }

    @Override
    public void rejectForm(Long formId) {
        var formRespuesta = formularioRespuestaRepository.findById(formId)
                .orElseThrow(() -> new SurveyPlatformException("Formulario no encontrado", 404));

        formRespuesta.setAprobado(false);
        formularioRespuestaRepository.save(formRespuesta);
    }


}
