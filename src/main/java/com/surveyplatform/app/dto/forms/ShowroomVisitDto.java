package com.surveyplatform.app.dto.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ShowroomVisitDto {
    private String visitFirstName;
    private String visitLastName;
    private String visitVehicle;
    private String dealRequirement;
}
