package com.surveyplatform.app.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeneralManagerDto {
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
    private String romiReportAnalyzed;
    private String reviewedForecast;
    private String correctiveActionSet;
    private String developedMarketingStrategies;
    private String developedMarketingWithVendors;
    private String ensuredTrainingStandards;
    private String ensuredMarketingDeployment;
    private String currentTurnoverRatio;
    private String setNewGoal;
    private String developedRecognitionProgram;
    private String achievedProfitability;
}
