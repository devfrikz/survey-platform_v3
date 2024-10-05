package com.surveyplatform.app.persistance.entities;

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
@Table(name = "formulario_internet_sales_manager", schema = "crm")
public class FormularioInternetSalesManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "response_time", nullable = false, length = 3)
    private String responseTime;

    @Column(name = "total_leads", nullable = false, length = 3)
    private String totalLeads;

    @Column(name = "closing_ratio", nullable = false, length = 3)
    private String closingRatio;

    @Column(name = "vehicles_have_pictures", nullable = false, length = 3)
    private String vehiclesHavePictures;

    @Column(name = "vehicles_have_comments", nullable = false, length = 3)
    private String vehiclesHaveComments;

    @Column(name = "comments_include_geotargeting", nullable = false, length = 3)
    private String commentsIncludeGeotargeting;

    @Column(name = "vehicles_have_prices", nullable = false, length = 3)
    private String vehiclesHavePrices;

    @Column(name = "fb_likes_goal_attained", nullable = false, length = 3)
    private String fbLikesGoalAttained;

    @Column(name = "reviews_goal_achieved", nullable = false, length = 3)
    private String reviewsGoalAchieved;

    @Column(name = "negative_reviews_answered", nullable = false, length = 3)
    private String negativeReviewsAnswered;

    @Column(name = "team_members_have_co_branded_websites", nullable = false, length = 3)
    private String teamMembersHaveCoBrandedWebsites;

    @Column(name = "team_members_on_linkedin", nullable = false, length = 3)
    private String teamMembersOnLinkedin;

    @Column(name = "team_members_on_instagram", nullable = false, length = 3)
    private String teamMembersOnInstagram;

    @Column(name = "srp_vdp_autotrader", nullable = false, length = 3)
    private String srpVdpAutotrader;

    @Column(name = "cars_com_achieved", nullable = false, length = 3)
    private String carsComAchieved;

    @Column(name = "click_through_ratio", nullable = false, length = 3)
    private String clickThroughRatio;

    @Column(name = "ppc_campaigns_sales", nullable = false, length = 3)
    private String ppcCampaignsSales;

    @Column(name = "lead_report_source_completed", nullable = false, length = 3)
    private String leadReportSourceCompleted;

    @Column(name = "roi_report_completed", nullable = false, length = 3)
    private String roiReportCompleted;

    @Column(name = "seo_analysis_conducted", nullable = false, length = 3)
    private String seoAnalysisConducted;

    @Column(name = "corrective_action_seo_agency", nullable = false, length = 3)
    private String correctiveActionSeoAgency;

    @Column(name = "sales_record_met_or_set", nullable = false, length = 3)
    private String salesRecordMetOrSet;

    @Column(name = "vehicles_acquired_kbb_ico", nullable = false, length = 3)
    private String vehiclesAcquiredKbbIco;

    @Column(name = "vehicles_purchased_vehicle_xchange", nullable = false, length = 3)
    private String vehiclesPurchasedVehicleXchange;

    @Column(name = "vehicles_sold_by_bdc_vehicle_xchange", nullable = false, length = 3)
    private String vehiclesSoldByBdcVehicleXchange;

    @Column(name = "vehicles_traded_by_sales_team", nullable = false, length = 3)
    private String vehiclesTradedBySalesTeam;

    @Column(name = "mystery_shop_emails_sent", nullable = false, length = 3)
    private String mysteryShopEmailsSent;

    @Column(name = "team_performance_recognition", nullable = false, length = 3)
    private String teamPerformanceRecognition;

    @Column(name = "teamwork_activities_conducted", nullable = false, length = 3)
    private String teamworkActivitiesConducted;

    @Column(name = "management_of_leads", nullable = false, length = 3)
    private String managementOfLeads;

    @Column(name = "team_members_delivered_vehicles", nullable = false, length = 3)
    private String teamMembersDeliveredVehicles;

    @Column(name = "team_meeting_conducted", nullable = false, length = 3)
    private String teamMeetingConducted;

    @Column(name = "goals_written_down", nullable = false, length = 3)
    private String goalsWrittenDown;

    @Column(name = "department_staffed_properly", nullable = false, length = 3)
    private String departmentStaffedProperly;

    @Column(name = "improvement_initiatives", nullable = false, length = 3)
    private String improvementInitiatives;

    @Column(name = "tools_for_performance", nullable = false, length = 3)
    private String toolsForPerformance;

    @Column(name = "personal_improvement_areas", nullable = false, length = 3)
    private String personalImprovementAreas;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "formulario_virtual_assistance_id", nullable = false)
    private FormularioVirtualAssistant formularioVirtualAssistance;

}