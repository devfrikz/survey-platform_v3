package com.surveyplatform.app.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeneralSalesManagerDto {
    private String storeNewVehiclesSalesMet;
    private String storePreOwnedVehicleSalesMet;
    private String reconTimeAt4DaysForTheMonth;
    private String storeFinanceObjectivesMet;
    private String newVehicleInventoryNext90Days;
    private String preOwnedVehicleInventoryNext60Days;
    private String allCoOpAdDollarsAppliedFor;
    private String advertisingCompliantWithStateLaws;
    private String adPlanReadyForNextMonth;
    private String websiteReviewConducted;
    private String performanceReviewNewCarManagers;
    private String performanceReviewPreOwnedSalesManagers;
    private String performanceReviewFinanceManagers;
    private String performanceReviewInternetSalesManager;
    private String financialStatementReview;
    private String trainingInitiativesEstablished;
    private String coachingSessionsConducted;
    private String csiScoresAchievedForTheMonth;
    private String goalsSetForTheFollowingMonth;
    private String goalsAndBudgetsCommunicatedToTeam;
    private String salesOperationsImprovementGrowth;
    private String selfImprovementMaterial;
    private String teamworkImprovementStrategies;
    private String teamworkImprovementStrategiesNextMonth;
    private String moraleImprovementStrategiesPreviousMonth;
    private String moraleImprovementStrategiesNextMonth;
    private String threeAreasForSelfImprovement;
}

