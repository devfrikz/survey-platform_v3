package com.surveyplatform.app.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class VirtualAssistanceDto {
    //General Management
    private String dealershipName;
    private String websiteUrl;
    private String firstName;
    private String lastName;
    private String position;
    private String email;
    private String phone;
    private String date;
    private String signatureData;
    private String consentAcknowledgment;

    private GeneralManagerDto generalManager;
    private GeneralSalesManagerDto generalSalesManager;
    private NewCarSalesManagerDto newCarSalesManager;
    private SalesManagerPreOwnedDto salesManagerPreOwned;
    private FinanceDirectorDto financeDirector;
    private InternetSalesManagerDto internetSalesManager;
    private PromotionalEventsDto promotionalEvents;
}
