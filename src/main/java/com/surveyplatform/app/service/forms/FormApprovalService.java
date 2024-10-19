package com.surveyplatform.app.service.forms;

import com.surveyplatform.app.dto.forms.FormularioDto;
import com.surveyplatform.app.dto.forms.SubmittedFormDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FormApprovalService {
    void addForm(SubmittedFormDto submittedFormDto);

    Page<FormularioDto> getPendingFormsBySucursalAndRol(Pageable pageable);

    void approveForm(Long formId);

    void rejectForm(Long formId);
}
