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

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "formulario_ssi_1000", schema = "crm")
public class FormularioSsi1000 {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "guest_name_first", nullable = false)
    private String guestNameFirst;

    @Column(name = "guest_name_last", nullable = false)
    private String guestNameLast;

    @Column(name = "vehicle_condition")
    private Boolean vehicleCondition;

    @Column(name = "full_tank")
    private Boolean fullTank;

    @Column(name = "jeep_wave")
    private Boolean jeepWave;

    @Column(name = "podded_vehicle")
    private Boolean poddedVehicle;

    @Column(name = "pair_phone")
    private Boolean pairPhone;

    @Column(name = "carplay_android_auto")
    private Boolean carplayAndroidAuto;

    @Column(name = "service_key_drop")
    private Boolean serviceKeyDrop;

    @Column(name = "service_walk")
    private Boolean serviceWalk;

    @Column(name = "os_plus_form")
    private Boolean osPlusForm;

    @Column(name = "survey_explanation")
    private Boolean surveyExplanation;

    @Column(name = "gdpr_consent", nullable = false)
    private Boolean gdprConsent = false;

    @Column(name = "privacy_consent", nullable = false)
    private Boolean privacyConsent = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "formulario_id")
    private Formulario formulario;

}