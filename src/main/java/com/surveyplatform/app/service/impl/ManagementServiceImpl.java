package com.surveyplatform.app.service.impl;

import com.surveyplatform.app.dto.SubmittedFormDto;
import com.surveyplatform.app.exception.SurveyPlatformException;
import com.surveyplatform.app.mapper.ManagementMapper;
import com.surveyplatform.app.persistance.entities.Formulario;
import com.surveyplatform.app.persistance.repository.FormularioCustomerNeedRepository;
import com.surveyplatform.app.persistance.repository.FormularioDailyPlannerRepository;
import com.surveyplatform.app.persistance.repository.FormularioDeliveryChecklistRepository;
import com.surveyplatform.app.persistance.repository.FormularioEndOfDayRepository;
import com.surveyplatform.app.persistance.repository.FormularioRepository;
import com.surveyplatform.app.persistance.repository.FormularioSsi1000Repository;
import com.surveyplatform.app.persistance.repository.FormularioTipoRepository;
import com.surveyplatform.app.persistance.repository.ModuleRepository;
import com.surveyplatform.app.persistance.repository.UsuarioRepository;
import com.surveyplatform.app.service.ManagementService;
import com.surveyplatform.app.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ManagementServiceImpl implements ManagementService {
    private final UsuarioRepository usuarioRepository;
    private final FormularioRepository formularioRepository;
    private final FormularioTipoRepository formularioTipoRepository;
    private final ModuleRepository moduleRepository;
    private final FormularioDailyPlannerRepository formularioDailyPlannerRepository;
    private final FormularioCustomerNeedRepository formularioCustomerNeedRepository;
    private final FormularioDeliveryChecklistRepository formularioDeliveryChecklistRepository;
    private final FormularioEndOfDayRepository formularioEndOfDayRepository;
    private final FormularioSsi1000Repository formularioSsi1000Repository;

    private final UsuarioService usuarioService;

    private static final Long SALES_FORM_TYPE = 5L;

    @Override
    @Transactional
    public void submitDailyPlanner(SubmittedFormDto submittedFormDto) {
        var formSaved = saveSalesForm();
        var formulario = ManagementMapper.MAPPER.toDailyPlannerEntity(submittedFormDto);
        formulario.setFormulario(formSaved);

        formularioDailyPlannerRepository.save(formulario);
    }

    @Override
    @Transactional
    public void submitCustomerNeeds(SubmittedFormDto submittedFormDto) {
        var formSaved = saveSalesForm();
        var formulario = ManagementMapper.MAPPER.toCustomerNeedEntity(submittedFormDto);
        formulario.setFormulario(formSaved);
        formularioCustomerNeedRepository.save(formulario);
    }

    @Override
    @Transactional
    public void submitDeliveryChecklist(SubmittedFormDto submittedFormDto) {
        log.info(submittedFormDto.toString());
        var formSaved = saveSalesForm();
        var formulario = ManagementMapper.MAPPER.toDeliveryChecklistEntity(submittedFormDto);
        formulario.setFormulario(formSaved);
        formularioDeliveryChecklistRepository.save(formulario);
    }

    @Override
    @Transactional
    public void submitEndOfDay(SubmittedFormDto submittedFormDto) {
        var formSaved = saveSalesForm();
        var formulario = ManagementMapper.MAPPER.toEndOfDayEntity(submittedFormDto);
        formulario.setFormulario(formSaved);
        formularioEndOfDayRepository.save(formulario);
    }

    @Override
    @Transactional
    public void submitSSi1000(SubmittedFormDto submittedFormDto) {
        var formSaved = saveSalesForm();
        var formulario = ManagementMapper.MAPPER.toSsi1000Entity(submittedFormDto);
        formulario.setFormulario(formSaved);
        formularioSsi1000Repository.save(formulario);
    }

    private Formulario saveSalesForm() {
        var usuarioLogueado = usuarioService.getLoggedUser();
        var usuario = usuarioRepository.findByEmail(usuarioLogueado).orElseThrow(() -> new SurveyPlatformException("Usuario no encontrado", 404));
        var formType = formularioTipoRepository.findById(SALES_FORM_TYPE).orElseThrow(() -> new SurveyPlatformException("Tipo de formulario no encontrado", 404));
        var module = moduleRepository.findById(1L).orElseThrow(() -> new SurveyPlatformException("Modulo no encontrado", 404));//TODO ver de donde obtener el modulo

        var form = Formulario.builder()
                .nombre(formType.getTipo())
                .descripcion(formType.getDescripcion())
                .modulo(module)
                .tipo(formType)
                .usuario(usuario)
                .build();

        return formularioRepository.save(form);
    }
}