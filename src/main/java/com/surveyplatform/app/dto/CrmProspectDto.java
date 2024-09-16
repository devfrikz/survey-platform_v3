package com.surveyplatform.app.dto;

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
