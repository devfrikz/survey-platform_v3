package com.surveyplatform.app.service;

import com.surveyplatform.app.dto.FormularioDto;
import com.surveyplatform.app.dto.SubmittedFormDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FormApprovalService {
    Page<FormularioDto> getPendingForms(Pageable pageable);

    void addForm(SubmittedFormDto submittedFormDto);

    Page<FormularioDto> getPendingFormsBySucursalAndRol(Pageable pageable, Long sucursalId, Long rolId);
}
