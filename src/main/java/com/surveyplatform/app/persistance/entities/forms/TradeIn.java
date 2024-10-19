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
@Table(name = "trade_in", schema = "crm")
public class TradeIn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "trade_in_year")
    private Integer tradeInYear;
    @Column(name = "trade_in_make")
    private String tradeInMake;
    @Column(name = "trade_in_model")
    private String tradeInModel;
    @Column(name = "trade_in_mileage")
    private Integer tradeInMileage;
    @Column(name = "trade_in_stock_number")
    private String tradeInStockNumber;
    @Column(name = "trade_in_date_acquired")
    private String tradeInDateAcquired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formulario_daily_planner_id", nullable = false)
    private FormularioDailyPlanner formularioDailyPlanner;
}
