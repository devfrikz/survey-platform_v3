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

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "facebook_market_place", schema = "crm")
public class FacebookMarketPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vehicle")
    private String vehicle;
    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model;
    @Column(name = "stock_number")
    private String stockNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formulario_end_of_day_id", nullable = false)
    private FormularioEndOfDay formularioEndOfDay;
}
