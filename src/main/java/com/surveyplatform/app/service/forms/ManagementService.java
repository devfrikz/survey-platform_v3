package com.surveyplatform.app.service.forms;

import com.surveyplatform.app.dto.forms.SubmittedFormDto;

public interface ManagementService {
    void submitDailyPlanner(SubmittedFormDto submittedFormDto);

    void submitCustomerNeeds(SubmittedFormDto submittedFormDto);

    void submitSSi1000(SubmittedFormDto submittedFormDto);

    void submitDeliveryChecklist(SubmittedFormDto submittedFormDto);

    void submitEndOfDay(SubmittedFormDto submittedFormDto);
}
