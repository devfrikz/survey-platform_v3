package com.surveyplatform.app.service;

import com.surveyplatform.app.dto.FormularioDto;
import com.surveyplatform.app.dto.SubmittedFormDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FormApprovalService {
    void addForm(SubmittedFormDto submittedFormDto);

    Page<FormularioDto> getPendingFormsBySucursalAndRol(Pageable pageable);
}
