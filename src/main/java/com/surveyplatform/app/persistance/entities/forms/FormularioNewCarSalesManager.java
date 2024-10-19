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
@Table(name = "formulario_new-car-sales-manager", schema = "crm")
public class FormularioNewCarSalesManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "conducted_one_on_ones_daily")
    private String conductedOneOnOnesDaily;

    @Column(name = "called_back_unsold_traffic_daily")
    private String calledBackUnsoldTrafficDaily;

    @Column(name = "all_sales_team_members_factory_certified")
    private String allSalesTeamMembersFactoryCertified;

    @Column(name = "all_sales_team_member_met_product_knowledge_proficiency")
    private String allSalesTeamMemberMetProductKnowledgeProficiency;

    @Column(name = "customer_satisfaction_scores_met_factory_standards")
    private String customerSatisfactionScoresMetFactoryStandards;

    @Column(name = "three_day_follow_up_completed")
    private String threeDayFollowUpCompleted;

    @Column(name = "conducted_two_training_sessions_per_week")
    private String conductedTwoTrainingSessionsPerWeek;

    @Column(name = "sixty_deals_closed_requirement_met")
    private String sixtyDealsClosedRequirementMet;

    @Column(name = "conducted_walkaround_presentation_training")
    private String conductedWalkaroundPresentationTraining;

    @Column(name = "reviewed_phone_ups_call_tracking_daily")
    private String reviewedPhoneUpsCallTrackingDaily;

    @Column(name = "conducted_two_phone_training_sessions")
    private String conductedTwoPhoneTrainingSessions;

    @Column(name = "provided_motivational_material")
    private String providedMotivationalMaterial;

    @Column(name = "maintained_inventory_levels")
    private String maintainedInventoryLevels;

    @Column(name = "merchandised_aged_inventory")
    private String merchandisedAgedInventory;

    @Column(name = "developed_sales_contests")
    private String developedSalesContests;

    @Column(name = "reviewed_internet_response_time")
    private String reviewedInternetResponseTime;

    @Column(name = "reviewed_internet_lost_sales")
    private String reviewedInternetLostSales;

    @Column(name = "reviewed_internet_merchandising")
    private String reviewedInternetMerchandising;

    @Column(name = "assisted_sales_staff_in_prospecting")
    private String assistedSalesStaffInProspecting;

    @Column(name = "created_sales_call_lists_for_equity_customers")
    private String createdSalesCallListsForEquityCustomers;

    @Column(name = "created_call_back_lists_for_lease_contracts")
    private String createdCallBackListsForLeaseContracts;

    @Column(name = "created_call_back_lists_for_trade_in_buy_back_offers")
    private String createdCallBackListsForTradeInBuyBackOffers;

    @Column(name = "secured_google_reviews")
    private String securedGoogleReviews;

    @Column(name = "secured_facebook_likes")
    private String securedFacebookLikes;

    @Column(name = "ensured_sales_staff_compliance_with_technology")
    private String ensuredSalesStaffComplianceWithTechnology;

    @Column(name = "distributed_good_press_articles")
    private String distributedGoodPressArticles;

    @Column(name = "praised_individuals_publicly")
    private String praisedIndividualsPublicly;

    @Column(name = "documented_performance_issues")
    private String documentedPerformanceIssues;

    @Column(name = "advertising_and_promotions_shared")
    private String advertisingAndPromotionsShared;

    @Column(name = "priced_vehicles_on_internet")
    private String pricedVehiclesOnInternet;

    @Column(name = "ensured_special_offers_posted_on_website")
    private String ensuredSpecialOffersPostedOnWebsite;

    @Column(name = "updated_personnel_on_website")
    private String updatedPersonnelOnWebsite;

    @Column(name = "zero_turnover_on_sales_team")
    private String zeroTurnoverOnSalesTeam;

    @Column(name = "save_a_deal_conducted_daily")
    private String saveADealConductedDaily;

    @Column(name = "early_introduction_to_customers")
    private String earlyIntroductionToCustomers;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "formulario_virtual_assistance_id", nullable = false)
    private FormularioVirtualAssistant formularioVirtualAssistance;

}