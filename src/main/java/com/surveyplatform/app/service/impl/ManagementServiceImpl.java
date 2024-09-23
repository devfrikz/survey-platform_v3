package com.surveyplatform.app.service.impl;

import com.surveyplatform.app.dto.SubmittedFormDto;
import com.surveyplatform.app.mapper.ManagementMapper;
import com.surveyplatform.app.persistance.repository.FormularioCustomerNeedRepository;
import com.surveyplatform.app.persistance.repository.FormularioDailyPlannerRepository;
import com.surveyplatform.app.persistance.repository.FormularioDeliveryChecklistRepository;
import com.surveyplatform.app.persistance.repository.FormularioEndOfDayRepository;
import com.surveyplatform.app.persistance.repository.FormularioSsi1000Repository;
import com.surveyplatform.app.service.FormularioService;
import com.surveyplatform.app.service.ManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ManagementServiceImpl implements ManagementService {
    private final FormularioDailyPlannerRepository formularioDailyPlannerRepository;
    private final FormularioCustomerNeedRepository formularioCustomerNeedRepository;
    private final FormularioDeliveryChecklistRepository formularioDeliveryChecklistRepository;
    private final FormularioEndOfDayRepository formularioEndOfDayRepository;
    private final FormularioSsi1000Repository formularioSsi1000Repository;

    private final FormularioService formularioService;

    private static final Long SALES_FORM_TYPE = 5L;


    @Override
    @Transactional
    public void submitDailyPlanner(SubmittedFormDto submittedFormDto) {
        var formSaved = formularioService.saveFormByType(SALES_FORM_TYPE);
        var formulario = ManagementMapper.MAPPER.toDailyPlannerEntityWithDetails(submittedFormDto);
        formulario.setFormulario(formSaved);

        formularioDailyPlannerRepository.save(formulario);
    }

    @Override
    @Transactional
    public void submitCustomerNeeds(SubmittedFormDto submittedFormDto) {
        var formSaved = formularioService.saveFormByType(SALES_FORM_TYPE);
        var formulario = ManagementMapper.MAPPER.toCustomerNeedEntity(submittedFormDto);
        formulario.setFormulario(formSaved);
        formularioCustomerNeedRepository.save(formulario);
    }

    @Override
    @Transactional
    public void submitDeliveryChecklist(SubmittedFormDto submittedFormDto) {
        log.info(submittedFormDto.toString());
        var formSaved = formularioService.saveFormByType(SALES_FORM_TYPE);
        var formulario = ManagementMapper.MAPPER.toDeliveryChecklistEntity(submittedFormDto);
        formulario.setFormulario(formSaved);
        formularioDeliveryChecklistRepository.save(formulario);
    }

    @Override
    @Transactional
    public void submitEndOfDay(SubmittedFormDto submittedFormDto) {
        var formSaved = formularioService.saveFormByType(SALES_FORM_TYPE);
        var formulario = ManagementMapper.MAPPER.toFormularioEndOfDayEntityWithDetails(submittedFormDto);
        formulario.setFormulario(formSaved);
        formularioEndOfDayRepository.save(formulario);
    }

    @Override
    @Transactional
    public void submitSSi1000(SubmittedFormDto submittedFormDto) {
        var formSaved = formularioService.saveFormByType(SALES_FORM_TYPE);
        var formulario = ManagementMapper.MAPPER.toSsi1000Entity(submittedFormDto);
        formulario.setFormulario(formSaved);
        formularioSsi1000Repository.save(formulario);
    }
}
