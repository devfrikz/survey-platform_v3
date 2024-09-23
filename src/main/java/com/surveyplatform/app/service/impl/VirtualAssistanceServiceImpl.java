package com.surveyplatform.app.service.impl;

import com.surveyplatform.app.dto.VirtualAssistanceDto;
import com.surveyplatform.app.mapper.VirtualAssistanceMapper;
import com.surveyplatform.app.persistance.repository.FormularioTipoRepository;
import com.surveyplatform.app.persistance.repository.VirtualAssistanceRepository;
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
    private final VirtualAssistanceRepository virtualAssistanceRepository;
    private final FormularioService formularioService;

    private static final Long VIRTUAL_FORM_TYPE = 6L;
    @Override
    @Transactional
    public void submitGeneralManagement(VirtualAssistanceDto virtualAssistanceDto) {
        var formSaved = formularioService.saveFormByType(VIRTUAL_FORM_TYPE);
        var virtualAssistance = VirtualAssistanceMapper.MAPPER.toEntity(virtualAssistanceDto);
        virtualAssistance.setFormulario(formSaved);
        virtualAssistanceRepository.save(virtualAssistance);
       log.info("Submitted form: {}", virtualAssistanceDto);
    }
}
