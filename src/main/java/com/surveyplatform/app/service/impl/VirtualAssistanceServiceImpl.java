package com.surveyplatform.app.service.impl;

import com.surveyplatform.app.dto.VirtualAssistanceDto;
import com.surveyplatform.app.mapper.VirtualAssistanceMapper;
import com.surveyplatform.app.persistance.entities.FormularioVirtualAssistant;
import com.surveyplatform.app.persistance.repository.FormularioGeneralSalesManagerRepository;
import com.surveyplatform.app.persistance.repository.FormularioTipoRepository;
import com.surveyplatform.app.persistance.repository.FormularioGeneralManagementRepository;
import com.surveyplatform.app.persistance.repository.FormularioVirtualAssistantRepository;
import com.surveyplatform.app.service.FormularioService;
import com.surveyplatform.app.service.VirtualAssistanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class VirtualAssistanceServiceImpl implements VirtualAssistanceService {
    private final FormularioTipoRepository formularioTipoRepository;
    private final FormularioGeneralManagementRepository formularioGeneralManagementRepository;
    private final FormularioGeneralSalesManagerRepository formularioGeneralSalesManagerRepository;
    private final FormularioVirtualAssistantRepository formularioVirtualAssistantRepository;
    private final FormularioService formularioService;

    private static final Long VIRTUAL_FORM_TYPE = 6L;
    @Override
    @Transactional
    public void submitGeneralManagement(VirtualAssistanceDto virtualAssistanceDto) {
        var virtualAssistance = saveVirtualAssistant(virtualAssistanceDto);
        var formularioGeneralManagement = VirtualAssistanceMapper.MAPPER.toEntityFormularioGeneralManagement(virtualAssistanceDto);
        formularioGeneralManagement.setFormularioVirtualAssistant(virtualAssistance);
        formularioGeneralManagementRepository.save(formularioGeneralManagement);
       log.info("Submitted form: {}", virtualAssistanceDto);
    }

    @Override
    @Transactional
    public void submitGeneralSalesManager(VirtualAssistanceDto virtualAssistanceDto) {
        var virtualAssistance = saveVirtualAssistant(virtualAssistanceDto);
        var formularioGeneralSalesManager = VirtualAssistanceMapper.MAPPER.toEntityFormularioGeneralSalesManager(virtualAssistanceDto);
        formularioGeneralSalesManager.setFormularioVirtualAssistant(virtualAssistance);

        formularioGeneralSalesManagerRepository.save(formularioGeneralSalesManager);
        log.info("Submitted form: {}", virtualAssistanceDto);
    }

    private FormularioVirtualAssistant saveVirtualAssistant(VirtualAssistanceDto virtualAssistanceDto) {
        var formSaved = formularioService.saveFormByType(VIRTUAL_FORM_TYPE);
        var virtualAssistance = VirtualAssistanceMapper.MAPPER.toEntityFormularioVirtualAssistant(virtualAssistanceDto);
        virtualAssistance.setFormulario(formSaved);
        return formularioVirtualAssistantRepository.save(virtualAssistance);
    }
}
