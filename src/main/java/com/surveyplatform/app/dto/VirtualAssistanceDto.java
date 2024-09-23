package com.surveyplatform.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString(includeFieldNames = true)
public class VirtualAssistanceDto {
    private String dealershipName;
    private String websiteUrl;
    private String firstName;
    private String lastName;
    private String position;
    private String email;
    private String phone;
    private String reviewedContracts;
    private String warrantyReceivables;
    private String titles;
    private String rebatesReceivables;
    private String reviewInsurance;
    private String reviewExpense;
    private String attendedUnemploymentHearings;
    private String documentedEmployeeIncident;
    private String documentedAccidentReports;
    private String reviewedMarketing;
    private String compliance;
    private String gatheredVirtualAssistantSurveys;
    private String romi;
    private String reviewedForecast;
    private String correctiveAction;
    private String developedMarketingStrategies;
    private String developedMarketingWithVendors;
    private String ensuredTrainingStandards;
    private String ensuredMarketingDeployment;
    private String currentTurnoverRatio;
    private String setNewGoal;
    private String developedRecognitionProgram;
    private String achievedProfitability;
    private String signatureData;
    private String consentAcknowledgment;

    @Override
    public String toString() {
        return "VirtualAssistanceDto {\n" +
                "  dealershipName='" + dealershipName + "',\n" +
                "  websiteUrl='" + websiteUrl + "',\n" +
                "  firstName='" + firstName + "',\n" +
                "  lastName='" + lastName + "',\n" +
                "  position='" + position + "',\n" +
                "  email='" + email + "',\n" +
                "  phone='" + phone + "',\n" +
                "  reviewedContracts='" + reviewedContracts + "',\n" +
                "  warrantyReceivables='" + warrantyReceivables + "',\n" +
                "  titles='" + titles + "',\n" +
                "  rebatesReceivables='" + rebatesReceivables + "',\n" +
                "  reviewInsurance='" + reviewInsurance + "',\n" +
                "  reviewExpense='" + reviewExpense + "',\n" +
                "  attendedUnemploymentHearings='" + attendedUnemploymentHearings + "',\n" +
                "  documentedEmployeeIncident='" + documentedEmployeeIncident + "',\n" +
                "  documentedAccidentReports='" + documentedAccidentReports + "',\n" +
                "  reviewedMarketing='" + reviewedMarketing + "',\n" +
                "  compliance='" + compliance + "',\n" +
                "  gatheredVirtualAssistantSurveys='" + gatheredVirtualAssistantSurveys + "',\n" +
                "  romiReportAnalyzed='" + romi + "',\n" +
                "  reviewedForecast='" + reviewedForecast + "',\n" +
                "  correctiveActionSet='" + correctiveAction + "',\n" +
                "  developedMarketingStrategies='" + developedMarketingStrategies + "',\n" +
                "  developedMarketingWithVendors='" + developedMarketingWithVendors + "',\n" +
                "  ensuredTrainingStandards='" + ensuredTrainingStandards + "',\n" +
                "  ensuredMarketingDeployment='" + ensuredMarketingDeployment + "',\n" +
                "  currentTurnoverRatio='" + currentTurnoverRatio + "',\n" +
                "  setNewGoal='" + setNewGoal + "',\n" +
                "  developedRecognitionProgram='" + developedRecognitionProgram + "',\n" +
                "  achievedProfitability='" + achievedProfitability + "',\n" +
                "  signatureData='" + signatureData + "',\n" +
                "  consentAcknowledgment='" + consentAcknowledgment + "'\n" +
                "}";
    }
}
