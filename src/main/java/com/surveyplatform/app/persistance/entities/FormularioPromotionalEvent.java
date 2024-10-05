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
@Table(name = "formulario_promotional_events", schema = "crm")
public class FormularioPromotionalEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "event_materials_ready", length = 3)
    private String eventMaterialsReady;

    @Column(name = "sales_tags", length = 3)
    private String salesTags;

    @Column(name = "banners", length = 3)
    private String banners;

    @Column(name = "prizes", length = 3)
    private String prizes;

    @Column(name = "worksheets", length = 3)
    private String worksheets;

    @Column(name = "appraisal_form_ready", length = 3)
    private String appraisalFormReady;

    @Column(name = "showroom_decor_ready", length = 3)
    private String showroomDecorReady;

    @Column(name = "registration_table", length = 3)
    private String registrationTable;

    @Column(name = "tables_for_showroom", length = 3)
    private String tablesForShowroom;

    @Column(name = "chairs", length = 3)
    private String chairs;

    @Column(name = "crowd_control", length = 3)
    private String crowdControl;

    @Column(name = "tents_valet_parking", length = 3)
    private String tentsValetParking;

    @Column(name = "service_tags_valet_parking", length = 3)
    private String serviceTagsValetParking;

    @Column(name = "cones_for_parking_area", length = 3)
    private String conesForParkingArea;

    @Column(name = "barricades_to_route_traffic", length = 3)
    private String barricadesToRouteTraffic;

    @Column(name = "designated_parking_valet", length = 3)
    private String designatedParkingValet;

    @Column(name = "traffic_flow_mapped", length = 3)
    private String trafficFlowMapped;

    @Column(name = "vests_for_valet", length = 3)
    private String vestsForValet;

    @Column(name = "additional_staff", length = 3)
    private String additionalStaff;

    @Column(name = "valet_parking", length = 3)
    private String valetParking;

    @Column(name = "sales_staff", length = 3)
    private String salesStaff;

    @Column(name = "closers", length = 3)
    private String closers;

    @Column(name = "billers", length = 3)
    private String billers;

    @Column(name = "communication_prior_to_sale", length = 3)
    private String communicationPriorToSale;

    @Column(name = "letter_to_all_staff", length = 3)
    private String letterToAllStaff;

    @Column(name = "letter_to_service_customer", length = 3)
    private String letterToServiceCustomer;

    @Column(name = "letter_to_vendors", length = 3)
    private String letterToVendors;

    @Column(name = "letter_to_outside_sales_consultants", length = 3)
    private String letterToOutsideSalesConsultants;

    @Column(name = "sales_tools", length = 3)
    private String salesTools;

    @Column(name = "deal_jackets_ready", length = 3)
    private String dealJacketsReady;

    @Column(name = "book_out_sheets", length = 3)
    private String bookOutSheets;

    @Column(name = "kbb_retail_valuations", length = 3)
    private String kbbRetailValuations;

    @Column(name = "carfax_reports", length = 3)
    private String carfaxReports;

    @Column(name = "event_promoted_high_traffic", length = 3)
    private String eventPromotedHighTraffic;

    @Column(name = "all_entry_doors", length = 3)
    private String allEntryDoors;

    @Column(name = "all_waiting_areas", length = 3)
    private String allWaitingAreas;

    @Column(name = "all_restrooms", length = 3)
    private String allRestrooms;

    @Column(name = "sales_tags_mirror_message", length = 3)
    private String salesTagsMirrorMessage;

    @Column(name = "e_commerce_support", length = 3)
    private String eCommerceSupport;

    @Column(name = "website_banners_support_event", length = 3)
    private String websiteBannersSupportEvent;

    @Column(name = "email_blast_to_customers", length = 3)
    private String emailBlastToCustomers;

    @Column(name = "email_to_outside_sales_consultants", length = 3)
    private String emailToOutsideSalesConsultants;

    @Column(name = "email_to_vendors", length = 3)
    private String emailToVendors;

    @Column(name = "social_media_supports_event", length = 3)
    private String socialMediaSupportsEvent;

    @Column(name = "digital_banners_support_event", length = 3)
    private String digitalBannersSupportEvent;

    @Column(name = "banners_in_3rd_party_vendor", length = 3)
    private String bannersIn3rdPartyVendor;

    @Column(name = "training_for_sales_staff", length = 3)
    private String trainingForSalesStaff;

    @Column(name = "sales_scripts_for_outbound_calls", length = 3)
    private String salesScriptsForOutboundCalls;

    @Column(name = "receptionists_greeting_supports_event", length = 3)
    private String receptionistsGreetingSupportsEvent;

    @Column(name = "incentives_for_referrals_staff", length = 3)
    private String incentivesForReferralsStaff;

    @Column(name = "incentives_for_referrals_vendors", length = 3)
    private String incentivesForReferralsVendors;

    @Column(name = "incentives_for_referrals_customers", length = 3)
    private String incentivesForReferralsCustomers;

    @Column(name = "pep_rally_prior_to_event", length = 3)
    private String pepRallyPriorToEvent;

    @Column(name = "daily_sales_meetings", length = 3)
    private String dailySalesMeetings;

    @Column(name = "thank_you_letter_to_staff", length = 3)
    private String thankYouLetterToStaff;

    @Column(name = "communication_to_customers_web", length = 3)
    private String communicationToCustomersWeb;

    @Column(name = "social_media_support_to_share_results", length = 3)
    private String socialMediaSupportToShareResults;

    @Column(name = "pep_rally_after_event", length = 3)
    private String pepRallyAfterEvent;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "formulario_virtual_assistance_id", nullable = false)
    private FormularioVirtualAssistant formularioVirtualAssistance;

}