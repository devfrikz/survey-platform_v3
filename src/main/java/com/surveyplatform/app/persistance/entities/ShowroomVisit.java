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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "showroom_visit", schema = "crm")
public class ShowroomVisit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "visit_first_name")
    private String visitFirstName;
    @Column(name = "visit_last_name")
    private String visitLastName;
    @Column(name = "visit_vehicle")
    private String visitVehicle;
    @Column(name = "deal_requirement")
    private String dealRequirement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formulario_daily_planner_id", nullable = false)
    private FormularioDailyPlanner formularioDailyPlanner;
}
