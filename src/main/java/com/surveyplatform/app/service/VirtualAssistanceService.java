package com.surveyplatform.app.service;

import com.surveyplatform.app.dto.VirtualAssistanceDto;
import org.springframework.transaction.annotation.Transactional;

public interface VirtualAssistanceService {
    void submitGeneralManagement(VirtualAssistanceDto submittedFormDto);

    @Transactional
    void submitGeneralSalesManager(VirtualAssistanceDto virtualAssistanceDto);

    @Transactional
    void submitSalesManagerEvaluation(VirtualAssistanceDto virtualAssistanceDto);
}
