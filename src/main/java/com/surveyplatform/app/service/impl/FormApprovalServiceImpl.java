package com.surveyplatform.app.service.impl;

import com.surveyplatform.app.dto.FormularioDto;
import com.surveyplatform.app.dto.SubmittedFormDto;
import com.surveyplatform.app.exception.SurveyPlatformException;
import com.surveyplatform.app.mapper.FormApprovalMapper;
import com.surveyplatform.app.persistance.entities.Formulario;
import com.surveyplatform.app.persistance.entities.FormularioCredito;
import com.surveyplatform.app.persistance.entities.FormularioDescuento;
import com.surveyplatform.app.persistance.entities.FormularioPermiso;
import com.surveyplatform.app.persistance.entities.FormularioReferenciado;
import com.surveyplatform.app.persistance.entities.FormularioRespuesta;
import com.surveyplatform.app.persistance.entities.Rol;
import com.surveyplatform.app.persistance.entities.Usuario;
import com.surveyplatform.app.persistance.repository.*;
import com.surveyplatform.app.service.FormApprovalService;
import com.surveyplatform.app.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class FormApprovalServiceImpl implements FormApprovalService {

    private final FormularioReferenciadoRepository formularioReferenciadoRepository;
    private final SucursalRepository sucursalRepository;
    private final ModuleRepository moduleRepository;
    private final FormularioRepository formularioRepository;
    private final FormularioTipoRepository formularioTipoRepository;
    private final FormularioRespuestaRepository formularioRespuestaRepository;
    private final FormularioDescuentoRepository formularioDescuentoRepository;
    private final FormularioCreditoRepository formularioCreditoRepository;
    private final FormularioPermisoRepository formularioPermisoRepository;

    private final UsuarioService userService;

    // Obtener formularios pendientes
    public Page<FormularioDto> getPendingForms(Pageable pageable) {
        var formularioRespuestas = formularioRespuestaRepository.findAll(pageable);

        // Mapeo directo desde FormularioRespuesta a FormularioDto
        var list = formularioRespuestas.getContent().stream()
                .map(FormApprovalMapper.MAPPER::toDto)
                .toList();

        return new PageImpl<>(list, pageable, formularioRespuestas.getTotalElements());
    }

    // Obtener formularios filtrados por sucursal y lista de IDs de roles
    @Override
    public Page<FormularioDto> getPendingFormsBySucursalAndRol(Pageable pageable) {
        var username = userService.getLoggedUser();
        var userOpt = userService.findByUsername(username);

        if (userOpt.isPresent()) {
            var user = userOpt.get();

            // Convertir los roles a una lista de IDs de tipo Long
            var roleIds = user.getRoles().stream()
                    .map(Rol::getId)
                    .toList();
            var formularioRespuestas = formularioRespuestaRepository.findBySucursalIdAndRoleIds(Long.valueOf(user.getSucursal().getId()), roleIds, pageable);

            // Mapear FormularioRespuesta a FormularioDto
            var list = formularioRespuestas.getContent().stream()
                    .map(FormApprovalMapper.MAPPER::toDto)
                    .toList();

            return new PageImpl<>(list, pageable, formularioRespuestas.getTotalElements());
        }

        throw new SurveyPlatformException("Usuario no encontrado", 404);
    }

    @Transactional
    public void addForm(SubmittedFormDto submittedFormDto) {
        var loggedUser = userService.getLoggedUser();

        // Buscar el usuario en la base de datos
        var user = userService.findByEmail(loggedUser)
                .orElseThrow(() -> new SurveyPlatformException("Usuario no encontrado", 404));

        // Acceder directamente a la sucursal desde el usuario
        var sucursal = user.getSucursal();  // Esto accede a la relación ManyToOne en la entidad Usuario

        // Verificar si la sucursal existe
        if (sucursal == null) {
            throw new SurveyPlatformException("Sucursal no encontrada para el usuario", 404);
        }

        // Encontrar el tipo de formulario basado en la descripción
        var formType = formularioTipoRepository.findByTipoIgnoreCase(submittedFormDto.getFormType())
                .orElseThrow(() -> new SurveyPlatformException("Tipo de formulario no encontrado", 404));

        // Encontrar el módulo asociado al formulario
        var module = moduleRepository.findById(1L)
                .orElseThrow(() -> new SurveyPlatformException("Modulo no encontrado", 404)); // TODO: Ver de dónde obtener el módulo

        // Crear el formulario
        var form = Formulario.builder()
                .nombre(formType.getDescripcion())
                .descripcion(submittedFormDto.getFormType())
                .modulo(module)
                .tipo(formType)
                .usuario(user)
                .build();

        var formSaved = formularioRepository.save(form);

        // Crear la respuesta del formulario asociada al usuario y la sucursal
        var formularioRespuesta = FormularioRespuesta.builder()
                .formulario(formSaved)
                .usuario(user)
                .sucursal(sucursal)  // Asignar la sucursal directamente desde el usuario
                .datos("") // TODO: Chequear para qué es este campo
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .updatedAt(new Timestamp(System.currentTimeMillis()))
                .build();

        // Lógica de guardado dependiendo del tipo de formulario (permiso, crédito, descuento, etc.)
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

        // Guardar la respuesta del formulario
        formularioRespuestaRepository.save(formularioRespuesta);
        log.info("Formulario guardado con ID: {}", formularioRespuesta.getId());
    }
}
