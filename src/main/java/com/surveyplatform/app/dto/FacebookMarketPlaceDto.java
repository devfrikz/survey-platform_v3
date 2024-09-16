package com.surveyplatform.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class FacebookMarketPlaceDto {
    private String vehicle;
    private String make;
    private String model;
    private String stockNumber;
}
