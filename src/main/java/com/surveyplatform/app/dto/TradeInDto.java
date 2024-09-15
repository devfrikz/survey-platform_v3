package com.surveyplatform.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TradeInDto {
    private Integer tradeInYear;
    private String tradeInMake;
    private String tradeInModel;
    private Integer tradeInMileage;
    private String tradeInStockNumber;
    private String tradeInDateAcquired;
}
