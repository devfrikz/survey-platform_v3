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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "formulario_daily_planner", schema = "crm")
public class FormularioDailyPlanner {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "delivered_up_to_date", nullable = false)
    private Integer deliveredUpToDate;

    @Column(name = "days_gone", nullable = false)
    private Integer daysGone;

    @Column(name = "average_sold_per_day", nullable = false, precision = 10, scale = 2)
    private BigDecimal averageSoldPerDay;

    @Column(name = "days_this_month", nullable = false)
    private Integer daysThisMonth;

    @Column(name = "tracking", nullable = false)
    private Integer tracking;

    @Column(name = "goal", nullable = false)
    private Integer goal;

    @Column(name = "plus_or_minus_goal", nullable = false)
    private Integer plusOrMinusGoal;

    @Column(name = "appointment_first_name", nullable = false)
    private String appointmentFirstName;

    @Column(name = "appointment_last_name", nullable = false)
    private String appointmentLastName;

    @Column(name = "appointment_vehicle", nullable = false)
    private String appointmentVehicle;

    @Column(name = "appointment_time", nullable = false)
    private LocalTime appointmentTime;

    @Column(name = "visit_first_name", nullable = false)
    private String visitFirstName;

    @Column(name = "visit_last_name", nullable = false)
    private String visitLastName;

    @Column(name = "visit_vehicle", nullable = false)
    private String visitVehicle;

    @Column(name = "deal_requirement", nullable = false, length = Integer.MAX_VALUE)
    private String dealRequirement;

    @Column(name = "fb_stock_number", nullable = false, length = 50)
    private String fbStockNumber;

    @Column(name = "fb_link", nullable = false, length = Integer.MAX_VALUE)
    private String fbLink;

    @Column(name = "fb_vehicle_type", nullable = false)
    private String fbVehicleType;

    @Column(name = "fb_listing_price", nullable = false, length = 50)
    private String fbListingPrice;

    @Column(name = "trade_in_year", nullable = false)
    private Integer tradeInYear;

    @Column(name = "trade_in_make", nullable = false)
    private String tradeInMake;

    @Column(name = "trade_in_model", nullable = false)
    private String tradeInModel;

    @Column(name = "trade_in_mileage", nullable = false)
    private Integer tradeInMileage;

    @Column(name = "trade_in_stock_number", nullable = false)
    private Integer tradeInStockNumber;

    @Column(name = "trade_in_date_acquired", nullable = false)
    private LocalDate tradeInDateAcquired;

    @Column(name = "referral_first_name", nullable = false)
    private String referralFirstName;

    @Column(name = "referral_last_name", nullable = false)
    private String referralLastName;

    @Column(name = "referral_reason", nullable = false, length = 50)
    private String referralReason;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "formulario_id")
    private Formulario formulario;

}