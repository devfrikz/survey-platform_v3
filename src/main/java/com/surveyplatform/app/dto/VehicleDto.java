package com.surveyplatform.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class VehicleDto {
    private String name;
    private String lastName;
    private String vehicle;
    private String hour;
    private String minute;
    private String amPm;
}
