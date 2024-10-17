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
@Table(name = "formulario_general_sales_manager_form", schema = "crm")
public class FormularioGeneralSalesManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "store_new_vehicles_sales_met", nullable = false, length = 10)
    private String storeNewVehiclesSalesMet;

    @Column(name = "store_pre_owned_vehicle_sales_met", nullable = false, length = 10)
    private String storePreOwnedVehicleSalesMet;

    @Column(name = "recon_time_at_4_days_for_the_month", nullable = false, length = 10)
    private String reconTimeAt4DaysForTheMonth;

    @Column(name = "store_finance_objectives_met", nullable = false, length = 10)
    private String storeFinanceObjectivesMet;

    @Column(name = "new_vehicle_inventory_next_90_days", nullable = false, length = 10)
    private String newVehicleInventoryNext90Days;

    @Column(name = "pre_owned_vehicle_inventory_next_60_days", nullable = false, length = 10)
    private String preOwnedVehicleInventoryNext60Days;

    @Column(name = "all_co_op_ad_dollars_applied_for", nullable = false, length = 10)
    private String allCoOpAdDollarsAppliedFor;

    @Column(name = "advertising_compliant_with_state_laws", nullable = false, length = 10)
    private String advertisingCompliantWithStateLaws;

    @Column(name = "ad_plan_ready_for_next_month", nullable = false, length = 10)
    private String adPlanReadyForNextMonth;

    @Column(name = "website_review_conducted", nullable = false, length = 10)
    private String websiteReviewConducted;

    @Column(name = "performance_review_new_car_managers", nullable = false, length = 10)
    private String performanceReviewNewCarManagers;

    @Column(name = "performance_review_pre_owned_sales_managers", nullable = false, length = 10)
    private String performanceReviewPreOwnedSalesManagers;

    @Column(name = "performance_review_finance_managers", nullable = false, length = 10)
    private String performanceReviewFinanceManagers;

    @Column(name = "performance_review_internet_sales_manager", nullable = false, length = 10)
    private String performanceReviewInternetSalesManager;

    @Column(name = "financial_statement_review", nullable = false, length = 10)
    private String financialStatementReview;

    @Column(name = "training_initiatives_established", nullable = false, length = 10)
    private String trainingInitiativesEstablished;

    @Column(name = "coaching_sessions_conducted", nullable = false, length = 10)
    private String coachingSessionsConducted;

    @Column(name = "csi_scores_achieved_for_the_month", nullable = false, length = 10)
    private String csiScoresAchievedForTheMonth;

    @Column(name = "goals_set_for_the_following_month", nullable = false, length = 10)
    private String goalsSetForTheFollowingMonth;

    @Column(name = "goals_and_budgets_communicated_to_team", nullable = false, length = 10)
    private String goalsAndBudgetsCommunicatedToTeam;

    @Column(name = "sales_operations_improvement_growth", nullable = false, length = 10)
    private String salesOperationsImprovementGrowth;

    @Column(name = "self_improvement_material", nullable = false, length = 10)
    private String selfImprovementMaterial;

    @Column(name = "teamwork_improvement_strategies", nullable = false, length = 10)
    private String teamworkImprovementStrategies;

    @Column(name = "teamwork_improvement_strategies_next_month", nullable = false, length = 10)
    private String teamworkImprovementStrategiesNextMonth;

    @Column(name = "morale_improvement_strategies_previous_month", nullable = false, length = 10)
    private String moraleImprovementStrategiesPreviousMonth;

    @Column(name = "morale_improvement_strategies_next_month", nullable = false, length = 10)
    private String moraleImprovementStrategiesNextMonth;

    @Column(name = "three_areas_for_self_improvement", nullable = false, length = 10)
    private String threeAreasForSelfImprovement;

    @Column(name = "signature_data", nullable = false, length = Integer.MAX_VALUE)
    private String signatureData;

    @Column(name = "consent_acknowledgment", nullable = false, length = 10)
    private String consentAcknowledgment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "formulario_virtual_assistance_id", nullable = false)
    private FormularioVirtualAssistant formularioVirtualAssistant;

}