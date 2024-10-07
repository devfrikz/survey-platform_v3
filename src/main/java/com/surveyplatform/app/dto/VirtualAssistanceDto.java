package com.surveyplatform.app.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    //General sales Manager
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

    //New Car Sales Manager
    private String conductedOneOnOnesDaily;
    private String calledBackUnsoldTrafficDaily;
    private String allSalesTeamMembersFactoryCertified;
    private String allSalesTeamMemberMetProductKnowledgeProficiency;
    private String customerSatisfactionScoresMetFactoryStandards;
    private String threeDayFollowUpCompleted;
    private String conductedTwoTrainingSessionsPerWeek;
    private String sixtyDealsClosedRequirementMet;
    private String conductedWalkaroundPresentationTraining;
    private String reviewedPhoneUpsCallTrackingDaily;
    private String conductedTwoPhoneTrainingSessions;
    private String providedMotivationalMaterial;
    private String maintainedInventoryLevels;
    private String merchandisedAgedInventory;
    private String developedSalesContests;
    private String reviewedInternetResponseTime;
    private String reviewedInternetLostSales;
    private String reviewedInternetMerchandising;
    private String assistedSalesStaffInProspecting;
    private String createdSalesCallListsForEquityCustomers;
    private String createdCallBackListsForLeaseContracts;
    private String createdCallBackListsForTradeInBuyBackOffers;
    private String securedGoogleReviews;
    private String securedFacebookLikes;
    private String ensuredSalesStaffComplianceWithTechnology;
    private String distributedGoodPressArticles;
    private String praisedIndividualsPublicly;
    private String documentedPerformanceIssues;
    private String advertisingAndPromotionsShared;
    private String pricedVehiclesOnInternet;
    private String ensuredSpecialOffersPostedOnWebsite;
    private String updatedPersonnelOnWebsite;
    private String zeroTurnoverOnSalesTeam;
    private String saveADealConductedDaily;
    private String earlyIntroductionToCustomers;

    //Sales Manager Pre-Owned
    private String tradeAcquisition60PercentAppraisals;
    private String zeroVehiclesOver90Days;
    private String usedVehiclesAverageDaysInInventory;
    private String vehiclesAcquisitionToMerchandising;
    private String allCarfaxAutochecksConducted;
    private String inventoryMixedAlignedWithRateOfSale;
    private String wholesaleGainForMonth;
    private String metFactoryRequirementsForCertifiedVehicles;
    private String allVehiclesPricedWeeklyOnInternet;
    private String allSpecialsUpdatedOnInternet;
    private String ninetyPercentVehiclesHavePhotosOnInternet;
    private String allSalesStaffMetInTechnologyRequirements;
    private String allAgedInventoryDisposedAtAuction;
    private String policyExpensesDidNotExceed1PercentGross;
    private String zeroLotDamageForMonth;
    private String driverLicensesCheckedBeforeTestDrives;
    private String allLoanerAgreementsSigned;
    private String allTestDrivesAccompaniedBySalesperson;
    private String conductedTrainingSessionsTwoPerWeek;
    private String reviewedUnsoldLeadsDaily;
    private String reviewedPhoneUpsDaily;
    private String conductedPhoneUpTraining;
    private String allAgedInventoryProperlyDisplayed;
    private String establishedSalesContests;
    private String followedPricingGuidelinesToPromoteFastTurn;
    private String achievedDepartmentUnitsPerformanceGoal;
    private String achievedDepartmentGrossGoal;
    private String achieved10CarsPerSalespersonAverage;
    private String areThereAnyTitlesMissing;
    private String hasAPhysicalInventoryBeenConducted;
    private String allStateGuidelinesForAdvertisingFollowed;
    private String allSoldDealsWorksheetsSavedInFiles;
    private String truthAndLendingDisclosuresFollowed;
    private String allSafetyInspectionsConductedPriorToOffering;
    private String allDisclosuresHavePricingClearlyMarked;
    private String allVehiclesOfferedHaveTitlesInStore;
    private String allCarfaxAutochecksReviewedAndSignedCopyKept;
    private String customerRequestedToSpeakToPreviousCustomer;
    private String sixtyDealsClosedForMonth;

    //Finance Director
    private String allTransactionsHaveRisk;
    private String contractsResolved;
    private String ofacChecksConducted;
    private String riskBasePricingNotice;
    private String customerInfoPrivate;
    private String creditApplicationsFilled;
    private String titlesCollected;
    private String preventCashShortages;
    private String productReserveRatio;
    private String chargebacksExceedTenPercent;
    private String performanceMinimumsForFinanceManagers;
    private String performanceRequirementsMet;
    private String idVerificationsCompleted;
    private String redFlagsRulesFollowed;
    private String pendingProductCancellations;
    private String csiPerformanceScoresMet;
    private String dealsEvenlyDistributed;
    private String zeroReturnedContracts;
    private String declinationNoticesSent;
    private String warrantyPenetrationAchieved;
    private String gapPenetrationAchieved;
    private String maintenancePenetrationAchieved;
    private String chemicalPenetrationAchieved;
    private String trainingSessionsConducted;
    private String initiativesForNextMonth;
    private String goalsWritten;
    private String promoteTeamworkMeasures;
    private String maintainHighMoraleMeasures;
    private String trainingRequirementsMet;
    private String personalImprovementAreas;

    //Common fields
    private String signatureData;
    private String consentAcknowledgment;
}
