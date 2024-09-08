package com.surveyplatform.app.service;

import com.surveyplatform.app.dto.FormularioDto;
import com.surveyplatform.app.dto.SubmittedFormDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FormApprovalService {
    Page<FormularioDto> getPendingForms(Pageable pageable);

    void addForm(SubmittedFormDto submittedFormDto);

    Page<FormularioDto> getPendingFormsBySucursalAndRol(Pageable pageable, Long sucursalId, List<Long> roleIds);
}
