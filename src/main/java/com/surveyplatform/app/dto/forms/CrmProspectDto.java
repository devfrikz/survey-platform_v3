package com.surveyplatform.app.dto.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CrmProspectDto {
    private String prospectFirstName;
    private String prospectLastName;
    private Integer crmCustomerNumber;
}
