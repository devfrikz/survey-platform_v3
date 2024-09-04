package com.surveyplatform.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class SubmittedFormDto {
    private String formType;
    private String permisoFecha;
    private Integer permisoDuracion;
    private BigDecimal creditoAmount;
    private String creditoCliente;
    private BigDecimal descuentoPorcentaje;
    private String descuentoRazon;
    private String nombreClienteReferenciado;
    private String emailClienteReferenciado;

    // Campos adicionales del formulario Customer Needs Analysis
    private String firstName;
    private String lastName;
    private String salesPersonName;
    private String address;
    private String cityState;
    private String zipCode;
    private String phone;
    private String email;
    private String hearAboutUs;
    private String vehicleType;
    private String stockNumber;
    private String vehicleUse;
    private String primaryDriver;
    private String otherDrivers;
    private String milesDriven;
    private String motivation;
    private String previousBusiness;
    private String wants;
    private String needs;
    private String currentVehicleYear;
    private String currentVehicleMake;
    private String currentVehicleModel;
    private String currentVehicleMiles;
    private String financedBy;
    private String payOff;
    private String termLength;
    private String currentPayment;
    private String downPayment;
    private String tradeEquity;
    private String likes;
    private String dislikes;
    private String readyToday;

    // Campos adicionales del formulario End of Day Update
    private String customerDeliveriesPhotos;
    private Integer colleaguePostsShared;
    private String customerTradeInsPhotos;
    private String sharedContentFound;

    private String facebookMarketPlaceVehicle;
    private String facebookMarketPlaceMake;
    private String facebookMarketPlaceModel;
    private String facebookMarketPlaceStockNumber;

    private String crmProspectFirstName;
    private String crmProspectLastName;
    private Integer crmProspectNumber;

    private Integer newCarsLeads;
    private Integer preOwnedLeads;
    private Integer newVehiclesDelivered;
    private Integer newVehiclesLeased;
    private Integer personalAverageSSI;
    private String newVehicleLastSaleDay;
    private Integer preOwnedVehiclesDelivered;
    private Integer dpFinalsSold;

    // Campos adicionales del formulario SSI 1000
    private String guestNameFirst;
    private String guestNameLast;
    private boolean vehicleCondition;
    private boolean fullTank;
    private boolean jeepWave;
    private boolean poddedVehicle;
    private boolean pairPhone;
    private boolean carplayAndroidAuto;
    private boolean serviceKeyDrop;
    private boolean serviceWalk;
    private boolean osPlusForm;
    private boolean surveyExplanation;
    private boolean gdprConsent;
    private boolean privacyConsent;

    // Campos adicionales del formulario Daily Planner
    private String date;
    private Integer deliveredUpToDate;
    private Integer daysGone;
    private Integer averageSoldPerDay;
    private Integer daysThisMonth;
    private Integer tracking;
    private Integer goal;
    private Integer plusOrMinusGoal;
    private String appointmentFirstName;
    private String appointmentLastName;
    private String appointmentVehicle;
    private String appointmentHour;
    private String appointmentMinute;
    private String appointmentAmPm;
    private String visitFirstName;
    private String visitLastName;
    private String visitVehicle;
    private String dealRequirement;
    private String fbStockNumber;
    private String fbLink;
    private String fbVehicleType;
    private String fbListingPrice;
    private Integer tradeInYear;
    private String tradeInMake;
    private String tradeInModel;
    private Integer tradeInMileage;
    private String tradeInStockNumber;
    private String tradeInDateAcquired;
    private String referralFirstName;
    private String referralLastName;
    private String referralReason;

    // Campos adicionales del formulario Delivery Checklist
    private String customerName;
    private String stock;
    private String vehicle;
    private String vehicleTypeJson;
    private String copyOfJson;
    private String signedJson;
    private String titlePlatesJson;
    private String depositAmount;
    private String collectedBy;
    private String collectedDate;
    private Boolean refund;
    private String refundedBy;
    private String refundDate;
    private String downPaymentAmount;
    private String totalCollected;
    private String fiInitials;
    private String fiDate;
    private String salesManagerChecklistJson;
    private String domCastleChecklistJson;
    private String notes;
}
