package com.surveyplatform.app.dto.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class FbMarketplaceVehicleDto {
    private String fbStockNumber;
    private String fbLink;
    private String fbVehicleType;
    private String fbListingPrice;
}

