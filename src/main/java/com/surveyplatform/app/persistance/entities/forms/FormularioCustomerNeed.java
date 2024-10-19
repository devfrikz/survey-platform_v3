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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "formulario_customer_needs", schema = "crm")
public class FormularioCustomerNeed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "sales_person_name", nullable = false)
    private String salesPersonName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city_state", nullable = false)
    private String cityState;

    @Column(name = "zip_code", nullable = false, length = 10)
    private String zipCode;

    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "hear_about_us", nullable = false)
    private String hearAboutUs;

    @Column(name = "vehicle_type", nullable = false, length = 50)
    private String vehicleType;

    @Column(name = "stock_number", nullable = false, length = 50)
    private String stockNumber;

    @Column(name = "vehicle_use", nullable = false, length = 50)
    private String vehicleUse;

    @Column(name = "primary_driver", nullable = false)
    private String primaryDriver;

    @Column(name = "other_drivers", nullable = false, length = Integer.MAX_VALUE)
    private String otherDrivers;

    @Column(name = "miles_driven", nullable = false, length = 50)
    private String milesDriven;

    @Column(name = "motivation", nullable = false)
    private String motivation;

    @Column(name = "previous_business", nullable = false, length = 3)
    private String previousBusiness;

    @Column(name = "wants", nullable = false, length = Integer.MAX_VALUE)
    private String wants;

    @Column(name = "needs", nullable = false, length = Integer.MAX_VALUE)
    private String needs;

    @Column(name = "current_vehicle_year", nullable = false, length = 4)
    private String currentVehicleYear;

    @Column(name = "current_vehicle_make", nullable = false)
    private String currentVehicleMake;

    @Column(name = "current_vehicle_model", nullable = false)
    private String currentVehicleModel;

    @Column(name = "current_vehicle_miles", nullable = false, length = 50)
    private String currentVehicleMiles;

    @Column(name = "financed_by", nullable = false)
    private String financedBy;

    @Column(name = "pay_off", nullable = false, length = 50)
    private String payOff;

    @Column(name = "term_length", nullable = false, length = 50)
    private String termLength;

    @Column(name = "current_payment", nullable = false, length = 50)
    private String currentPayment;

    @Column(name = "down_payment", nullable = false, length = 50)
    private String downPayment;

    @Column(name = "trade_equity", nullable = false, length = 50)
    private String tradeEquity;

    @Column(name = "likes", nullable = false, length = Integer.MAX_VALUE)
    private String likes;

    @Column(name = "dislikes", nullable = false, length = Integer.MAX_VALUE)
    private String dislikes;

    @Column(name = "ready_today", nullable = false, length = 10)
    private String readyToday;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "formulario_id")
    private Formulario formulario;

}