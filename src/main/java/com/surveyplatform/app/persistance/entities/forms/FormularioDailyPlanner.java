package com.surveyplatform.app.persistance.entities.forms;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "formulario_id")
    private Formulario formulario;

    @OneToMany(mappedBy = "formularioDailyPlanner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vehicle> vehicles;

    @OneToMany(mappedBy = "formularioDailyPlanner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShowroomVisit> showroomVisits;

    @OneToMany(mappedBy = "formularioDailyPlanner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FbMarketplaceVehicle> fbMarketplaceVehicles;

    @OneToMany(mappedBy = "formularioDailyPlanner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TradeIn> tradeIns;

    @OneToMany(mappedBy = "formularioDailyPlanner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Referral> referrals;

}