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

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fb_marketplace_vehicle", schema = "crm")
public class FbMarketplaceVehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fb_stock_number")
    private String fbStockNumber;
    @Column(name = "fb_link")
    private String fbLink;
    @Column(name = "fb_vehicle_type")
    private String fbVehicleType;
    @Column(name = "fb_listing_price")
    private String fbListingPrice;

    // Many-to-one relationship with FormularioDailyPlanner
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formulario_daily_planner_id", nullable = false)
    private FormularioDailyPlanner formularioDailyPlanner;
}


