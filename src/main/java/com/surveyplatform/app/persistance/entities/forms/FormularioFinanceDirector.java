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
@Table(name = "formulario_finance_director", schema = "crm")
public class FormularioFinanceDirector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "all_transactions_have_risk", nullable = false, length = 3)
    private String allTransactionsHaveRisk;

    @Column(name = "contracts_resolved", nullable = false, length = 3)
    private String contractsResolved;

    @Column(name = "ofac_checks_conducted", nullable = false, length = 3)
    private String ofacChecksConducted;

    @Column(name = "risk_base_pricing_notice", nullable = false, length = 3)
    private String riskBasePricingNotice;

    @Column(name = "customer_info_private", nullable = false, length = 3)
    private String customerInfoPrivate;

    @Column(name = "credit_applications_filled", nullable = false, length = 3)
    private String creditApplicationsFilled;

    @Column(name = "titles_collected", nullable = false, length = 3)
    private String titlesCollected;

    @Column(name = "prevent_cash_shortages", nullable = false, length = 3)
    private String preventCashShortages;

    @Column(name = "product_reserve_ratio", nullable = false, length = 3)
    private String productReserveRatio;

    @Column(name = "chargebacks_exceed_ten_percent", nullable = false, length = 3)
    private String chargebacksExceedTenPercent;

    @Column(name = "performance_minimums_for_finance_managers", nullable = false, length = 3)
    private String performanceMinimumsForFinanceManagers;

    @Column(name = "performance_requirements_met", nullable = false, length = 3)
    private String performanceRequirementsMet;

    @Column(name = "id_verifications_completed", nullable = false, length = 3)
    private String idVerificationsCompleted;

    @Column(name = "red_flags_rules_followed", nullable = false, length = 3)
    private String redFlagsRulesFollowed;

    @Column(name = "pending_product_cancellations", nullable = false, length = 3)
    private String pendingProductCancellations;

    @Column(name = "csi_performance_scores_met", nullable = false, length = 3)
    private String csiPerformanceScoresMet;

    @Column(name = "deals_evenly_distributed", nullable = false, length = 3)
    private String dealsEvenlyDistributed;

    @Column(name = "zero_returned_contracts", nullable = false, length = 3)
    private String zeroReturnedContracts;

    @Column(name = "declination_notices_sent", nullable = false, length = 3)
    private String declinationNoticesSent;

    @Column(name = "warranty_penetration_achieved", nullable = false, length = 3)
    private String warrantyPenetrationAchieved;

    @Column(name = "gap_penetration_achieved", nullable = false, length = 3)
    private String gapPenetrationAchieved;

    @Column(name = "maintenance_penetration_achieved", nullable = false, length = 3)
    private String maintenancePenetrationAchieved;

    @Column(name = "chemical_penetration_achieved", nullable = false, length = 3)
    private String chemicalPenetrationAchieved;

    @Column(name = "training_sessions_conducted", nullable = false, length = 3)
    private String trainingSessionsConducted;

    @Column(name = "initiatives_for_next_month", length = Integer.MAX_VALUE)
    private String initiativesForNextMonth;

    @Column(name = "goals_written", nullable = false, length = 3)
    private String goalsWritten;

    @Column(name = "promote_teamwork_measures", nullable = false, length = 3)
    private String promoteTeamworkMeasures;

    @Column(name = "explain_no_answers", length = Integer.MAX_VALUE)
    private String explainNoAnswers;

    @Column(name = "maintain_high_morale_measures", nullable = false, length = 3)
    private String maintainHighMoraleMeasures;

    @Column(name = "training_requirements_met", nullable = false, length = 3)
    private String trainingRequirementsMet;

    @Column(name = "personal_improvement_areas", nullable = false, length = 3)
    private String personalImprovementAreas;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "formulario_virtual_assistance_id", nullable = false)
    private FormularioVirtualAssistant formularioVirtualAssistance;

}