package com.surveyplatform.app.persistance.entities.forms;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "formulario_sales_manager_pre_owned", schema = "crm")
public class FormularioSalesManagerPreOwned {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "trade_acquisition_60_percent_appraisals", nullable = false, length = 50)
    private String tradeAcquisition60PercentAppraisals;

    @Column(name = "zero_vehicles_over_90_days", nullable = false, length = 50)
    private String zeroVehiclesOver90Days;

    @Column(name = "used_vehicles_average_days_in_inventory", nullable = false, length = 50)
    private String usedVehiclesAverageDaysInInventory;

    @Column(name = "vehicles_acquisition_to_merchandising", nullable = false, length = 50)
    private String vehiclesAcquisitionToMerchandising;

    @Column(name = "all_carfax_autochecks_conducted", nullable = false, length = 50)
    private String allCarfaxAutochecksConducted;

    @Column(name = "inventory_mixed_aligned_with_rate_of_sale", nullable = false, length = 50)
    private String inventoryMixedAlignedWithRateOfSale;

    @Column(name = "wholesale_gain_for_month", nullable = false, length = 50)
    private String wholesaleGainForMonth;

    @Column(name = "met_factory_requirements_for_certified_vehicles", nullable = false, length = 50)
    private String metFactoryRequirementsForCertifiedVehicles;

    @Column(name = "all_vehicles_priced_weekly_on_internet", nullable = false, length = 50)
    private String allVehiclesPricedWeeklyOnInternet;

    @Column(name = "all_specials_updated_on_internet", nullable = false, length = 50)
    private String allSpecialsUpdatedOnInternet;

    @Column(name = "ninety_percent_vehicles_have_photos_on_internet", nullable = false, length = 50)
    private String ninetyPercentVehiclesHavePhotosOnInternet;

    @Column(name = "all_sales_staff_met_in_technology_requirements", nullable = false, length = 50)
    private String allSalesStaffMetInTechnologyRequirements;

    @Column(name = "all_aged_inventory_disposed_at_auction", nullable = false, length = 50)
    private String allAgedInventoryDisposedAtAuction;

    @Column(name = "policy_expenses_did_not_exceed_1_percent_gross", nullable = false, length = 50)
    private String policyExpensesDidNotExceed1PercentGross;

    @Column(name = "zero_lot_damage_for_month", nullable = false, length = 50)
    private String zeroLotDamageForMonth;

    @Column(name = "driver_licenses_checked_before_test_drives", nullable = false, length = 50)
    private String driverLicensesCheckedBeforeTestDrives;

    @Column(name = "all_loaner_agreements_signed", nullable = false, length = 50)
    private String allLoanerAgreementsSigned;

    @Column(name = "all_test_drives_accompanied_by_salesperson", nullable = false, length = 50)
    private String allTestDrivesAccompaniedBySalesperson;

    @Column(name = "conducted_training_sessions_two_per_week", nullable = false, length = 50)
    private String conductedTrainingSessionsTwoPerWeek;

    @Column(name = "reviewed_unsold_leads_daily", nullable = false, length = 50)
    private String reviewedUnsoldLeadsDaily;

    @Column(name = "reviewed_phone_ups_daily", nullable = false, length = 50)
    private String reviewedPhoneUpsDaily;

    @Column(name = "conducted_phone_up_training", nullable = false, length = 50)
    private String conductedPhoneUpTraining;

    @Column(name = "all_aged_inventory_properly_displayed", nullable = false, length = 50)
    private String allAgedInventoryProperlyDisplayed;

    @Column(name = "established_sales_contests", nullable = false, length = 50)
    private String establishedSalesContests;

    @Column(name = "followed_pricing_guidelines_to_promote_fast_turn", nullable = false, length = 50)
    private String followedPricingGuidelinesToPromoteFastTurn;

    @Column(name = "achieved_department_units_performance_goal", nullable = false, length = 50)
    private String achievedDepartmentUnitsPerformanceGoal;

    @Column(name = "achieved_department_gross_goal", nullable = false, length = 50)
    private String achievedDepartmentGrossGoal;

    @Column(name = "achieved_10_cars_per_salesperson_average", nullable = false, length = 50)
    private String achieved10CarsPerSalespersonAverage;

    @Column(name = "are_there_any_titles_missing", nullable = false, length = 50)
    private String areThereAnyTitlesMissing;

    @Column(name = "has_a_physical_inventory_been_conducted", nullable = false, length = 50)
    private String hasAPhysicalInventoryBeenConducted;

    @Column(name = "all_state_guidelines_for_advertising_followed", nullable = false, length = 50)
    private String allStateGuidelinesForAdvertisingFollowed;

    @Column(name = "all_sold_deals_worksheets_saved_in_files", nullable = false, length = 50)
    private String allSoldDealsWorksheetsSavedInFiles;

    @Column(name = "truth_and_lending_disclosures_followed", nullable = false, length = 50)
    private String truthAndLendingDisclosuresFollowed;

    @Column(name = "all_safety_inspections_conducted_prior_to_offering", nullable = false, length = 50)
    private String allSafetyInspectionsConductedPriorToOffering;

    @Column(name = "all_disclosures_have_pricing_clearly_marked", nullable = false, length = 50)
    private String allDisclosuresHavePricingClearlyMarked;

    @Column(name = "all_vehicles_offered_have_titles_in_store", nullable = false, length = 50)
    private String allVehiclesOfferedHaveTitlesInStore;

    @Column(name = "all_carfax_autochecks_reviewed_and_signed_copy_kept", nullable = false, length = 50)
    private String allCarfaxAutochecksReviewedAndSignedCopyKept;

    @Column(name = "customer_requested_to_speak_to_previous_customer", nullable = false, length = 50)
    private String customerRequestedToSpeakToPreviousCustomer;

    @Column(name = "sixty_deals_closed_for_month", nullable = false, length = 50)
    private String sixtyDealsClosedForMonth;

    @Column(name = "early_introduction_to_customers", nullable = false, length = 50)
    private String earlyIntroductionToCustomers;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "formulario_virtual_assistance_id", nullable = false)
    private FormularioVirtualAssistant formularioVirtualAssistance;

}