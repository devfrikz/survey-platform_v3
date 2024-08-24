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
import com.surveyplatform.app.persistance.repository.FormularioCreditoRepository;
import com.surveyplatform.app.persistance.repository.FormularioDescuentoRepository;
import com.surveyplatform.app.persistance.repository.FormularioPermisoRepository;
import com.surveyplatform.app.persistance.repository.FormularioReferenciadoRepository;
import com.surveyplatform.app.persistance.repository.FormularioRespuestaRepository;
import com.surveyplatform.app.persistance.repository.FormularioRepository;
import com.surveyplatform.app.persistance.repository.FormularioTipoRepository;
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
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDate;

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

    public Page<FormularioDto> getPendingForms(Pageable pageable) {
        var forms = formularioRespuestaRepository.findAll(pageable);
        var list = forms.getContent().stream().map(FormApprovalMapper.MAPPER::toDto).toList();

        return new PageImpl<>(list, pageable, forms.getTotalElements());
    }

    @Transactional
    public void addForm(SubmittedFormDto submittedFormDto) {
        var loggedUser = userService.getLoggedUser();

        var user = userService.findByEmail(loggedUser).orElseThrow(() -> new SurveyPlatformException("Usuario no encontrado", 404));
        var sucursal = sucursalRepository.findById(user.getSucursalId()).orElseThrow(() -> new SurveyPlatformException("Sucursal no encontrada", 404));
        var formType = formularioTipoRepository.findByTipoIgnoreCase(submittedFormDto.getFormType()).orElseThrow(() -> new SurveyPlatformException("Tipo de formulario no encontrado", 404));
        var module = moduleRepository.findById(1L).orElseThrow(() -> new SurveyPlatformException("Modulo no encontrado", 404));//TODO ver de donde obtener el modulo

        var form = Formulario.builder()
                .nombre(formType.getDescripcion())
                .descripcion(submittedFormDto.getFormType())
                .modulo(module)
                .tipo(formType)
                .build();

        var formSaved = formularioRepository.save(form);

        var formularioRespuesta = FormularioRespuesta.builder()
                .formulario(formSaved)
                .usuario(user)
                .sucursal(sucursal)
                .datos("")//TODO chequear para que es este campo
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
                log.info("Guardando formulario de permiso");
            }
            case "credito" -> {
                var formularioCredito = FormularioCredito.builder()
                        .formulario(formSaved)
                        .montoCredito(submittedFormDto.getCreditoAmount())
                        .nombreCliente(submittedFormDto.getCreditoCliente())
                        .build();
                formularioCreditoRepository.save(formularioCredito);
                log.info("Guardando formulario de crédito");
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
                log.info("Guardando formulario de referido");
            }
            default -> {
                var message = "Tipo de formulario no soportado: " + submittedFormDto.getFormType();
                throw new SurveyPlatformException(message, 400);
            }
        }

        formularioRespuestaRepository.save(formularioRespuesta);
        log.info("Formulario guardado: {}", formularioRespuesta.getId());
    }
}
