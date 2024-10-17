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
@Table(name = "formulario_general_management", schema = "crm")
public class FormularioGeneralManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "reviewed_contracts", length = 3)
    private String reviewedContracts;

    @Column(name = "warranty_receivables", length = 3)
    private String warrantyReceivables;

    @Column(name = "titles", length = 3)
    private String titles;

    @Column(name = "rebates_receivables", length = 3)
    private String rebatesReceivables;

    @Column(name = "review_insurance", length = 3)
    private String reviewInsurance;

    @Column(name = "review_expense", length = 3)
    private String reviewExpense;

    @Column(name = "attended_unemployment_hearings", length = 3)
    private String attendedUnemploymentHearings;

    @Column(name = "documented_employee_incident", length = 3)
    private String documentedEmployeeIncident;

    @Column(name = "documented_accident_reports", length = 3)
    private String documentedAccidentReports;

    @Column(name = "reviewed_marketing", length = 3)
    private String reviewedMarketing;

    @Column(name = "compliance", length = 3)
    private String compliance;

    @Column(name = "gathered_virtual_assistant_surveys", length = 3)
    private String gatheredVirtualAssistantSurveys;

    @Column(name = "romi_report_analyzed", length = 3)
    private String romiReportAnalyzed;

    @Column(name = "reviewed_forecast", length = 3)
    private String reviewedForecast;

    @Column(name = "corrective_action_set", length = 3)
    private String correctiveActionSet;

    @Column(name = "developed_marketing_strategies", length = 3)
    private String developedMarketingStrategies;

    @Column(name = "developed_marketing_with_vendors", length = 3)
    private String developedMarketingWithVendors;

    @Column(name = "ensured_training_standards", length = 3)
    private String ensuredTrainingStandards;

    @Column(name = "ensured_marketing_deployment", length = 3)
    private String ensuredMarketingDeployment;

    @Column(name = "current_turnover_ratio", length = 3)
    private String currentTurnoverRatio;

    @Column(name = "set_new_goal", length = 3)
    private String setNewGoal;

    @Column(name = "developed_recognition_program", length = 3)
    private String developedRecognitionProgram;

    @Column(name = "achieved_profitability", length = 3)
    private String achievedProfitability;

    @Column(name = "signature_data", length = Integer.MAX_VALUE)
    private String signatureData;

    @Column(name = "consent_acknowledgment", length = 3)
    private String consentAcknowledgment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "formulario_virtual_assistance_id", nullable = false)
    private FormularioVirtualAssistant formularioVirtualAssistant;

}