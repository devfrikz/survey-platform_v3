package com.surveyplatform.app.service.forms.impl;

import com.surveyplatform.app.dto.forms.VirtualAssistanceDto;
import com.surveyplatform.app.mapper.VirtualAssistanceMapper;
import com.surveyplatform.app.persistance.entities.forms.FormularioVirtualAssistant;
import com.surveyplatform.app.persistance.repository.forms.FormularioFinanceDirectorRepository;
import com.surveyplatform.app.persistance.repository.forms.FormularioGeneralSalesManagerRepository;
import com.surveyplatform.app.persistance.repository.forms.FormularioInternetSalesManagerRepository;
import com.surveyplatform.app.persistance.repository.forms.FormularioPromotionalEventRepository;
import com.surveyplatform.app.persistance.repository.forms.FormularioSalesManagerPreOwnedRepository;
import com.surveyplatform.app.persistance.repository.forms.FormulariotoNewCarSalesManagerRepository;
import com.surveyplatform.app.persistance.repository.forms.FormularioGeneralManagementRepository;
import com.surveyplatform.app.persistance.repository.forms.FormularioVirtualAssistantRepository;
import com.surveyplatform.app.service.forms.FormularioService;
import com.surveyplatform.app.service.forms.VirtualAssistanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class VirtualAssistanceServiceImpl implements VirtualAssistanceService {
    private final FormularioGeneralManagementRepository formularioGeneralManagementRepository;
    private final FormularioGeneralSalesManagerRepository formularioGeneralSalesManagerRepository;
    private final FormularioVirtualAssistantRepository formularioVirtualAssistantRepository;
    private final FormulariotoNewCarSalesManagerRepository formulariotoNewCarSalesManagerRepository;
    private final FormularioSalesManagerPreOwnedRepository formularioSalesManagerPreOwnedRepository;
    private final FormularioFinanceDirectorRepository formularioFinanceDirectorRepository;
    private final FormularioInternetSalesManagerRepository formularioInternetSalesManagerRepository;
    private final FormularioPromotionalEventRepository formularioPromotionalEventRepository;

    private final FormularioService formularioService;

    public static final String SUBMITTED_FORM = "Submitted form: {}";
    private static final Long VIRTUAL_FORM_TYPE = 6L;

    @Override
    @Transactional
    public void submitGeneralManagement(VirtualAssistanceDto virtualAssistanceDto) {
        var virtualAssistance = saveVirtualAssistant(virtualAssistanceDto);
        var formularioGeneralManagement = VirtualAssistanceMapper.MAPPER.toEntityFormularioGeneralManagement(virtualAssistanceDto);
        formularioGeneralManagement.setFormularioVirtualAssistant(virtualAssistance);
        formularioGeneralManagementRepository.save(formularioGeneralManagement);
       log.info(SUBMITTED_FORM, virtualAssistanceDto);
    }

    @Override
    @Transactional
    public void submitGeneralSalesManager(VirtualAssistanceDto virtualAssistanceDto) {
        var virtualAssistance = saveVirtualAssistant(virtualAssistanceDto);
        var formularioGeneralSalesManager = VirtualAssistanceMapper.MAPPER.toEntityFormularioGeneralSalesManager(virtualAssistanceDto);
        formularioGeneralSalesManager.setFormularioVirtualAssistant(virtualAssistance);

        formularioGeneralSalesManagerRepository.save(formularioGeneralSalesManager);
        log.info(SUBMITTED_FORM, virtualAssistanceDto);
    }

    @Override
    @Transactional
    public void submitSalesManagerEvaluation(VirtualAssistanceDto virtualAssistanceDto) {
        var virtualAssistance = saveVirtualAssistant(virtualAssistanceDto);
        var formularioSalesManagerEvaluation = VirtualAssistanceMapper.MAPPER.toEntityNewCarSalesManager(virtualAssistanceDto);
        formularioSalesManagerEvaluation.setFormularioVirtualAssistance(virtualAssistance);

        formulariotoNewCarSalesManagerRepository.save(formularioSalesManagerEvaluation);
        log.info(SUBMITTED_FORM, virtualAssistanceDto);
    }

    @Override
    @Transactional
    public void submitSalesManagerPreOwned(VirtualAssistanceDto virtualAssistanceDto) {
        var virtualAssistance = saveVirtualAssistant(virtualAssistanceDto);
        var formularioSalesManagerPreOwned = VirtualAssistanceMapper.MAPPER.toEntityFormularioSalesManagerPreOwned(virtualAssistanceDto);
        formularioSalesManagerPreOwned.setFormularioVirtualAssistance(virtualAssistance);

        formularioSalesManagerPreOwnedRepository.save(formularioSalesManagerPreOwned);
        log.info(SUBMITTED_FORM, virtualAssistanceDto);
    }

    @Override
    @Transactional
    public void submitFinanceDirector(VirtualAssistanceDto virtualAssistanceDto) {
        var virtualAssistance = saveVirtualAssistant(virtualAssistanceDto);
        var formularioFinanceDirector = VirtualAssistanceMapper.MAPPER.toEntityFormularioFinanceDirector(virtualAssistanceDto);
        formularioFinanceDirector.setFormularioVirtualAssistance(virtualAssistance);

        formularioFinanceDirectorRepository.save(formularioFinanceDirector);
        log.info(SUBMITTED_FORM, virtualAssistanceDto);
    }

    @Override
    public void submitInternetSalesManager(VirtualAssistanceDto virtualAssistanceDto) {
        var virtualAssistance = saveVirtualAssistant(virtualAssistanceDto);
        var formularioInternetSalesManager = VirtualAssistanceMapper.MAPPER.toEntityFormularioInternetSalesManager(virtualAssistanceDto);
        formularioInternetSalesManager.setFormularioVirtualAssistance(virtualAssistance);

        formularioInternetSalesManagerRepository.save(formularioInternetSalesManager);
        log.info(SUBMITTED_FORM, virtualAssistanceDto);
    }

    @Override
    public void submitPromotionalEvent(VirtualAssistanceDto virtualAssistanceDto) {
        var virtualAssistance = saveVirtualAssistant(virtualAssistanceDto);
        var formularioPromotionalEvent = VirtualAssistanceMapper.MAPPER.toEntityFormularioPromotionalEvent(virtualAssistanceDto);
        formularioPromotionalEvent.setFormularioVirtualAssistance(virtualAssistance);

        formularioPromotionalEventRepository.save(formularioPromotionalEvent);
        log.info(SUBMITTED_FORM, virtualAssistanceDto);
    }

    private FormularioVirtualAssistant saveVirtualAssistant(VirtualAssistanceDto virtualAssistanceDto) {
        var formSaved = formularioService.saveFormByType(VIRTUAL_FORM_TYPE);
        var virtualAssistance = VirtualAssistanceMapper.MAPPER.toEntityFormularioVirtualAssistant(virtualAssistanceDto);
        virtualAssistance.setFormulario(formSaved);
        return formularioVirtualAssistantRepository.save(virtualAssistance);
    }
}
