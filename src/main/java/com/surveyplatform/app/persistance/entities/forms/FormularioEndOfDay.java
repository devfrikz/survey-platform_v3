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
import java.util.List;

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "formulario_end_of_day", schema = "crm")
public class FormularioEndOfDay {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "customer_deliveries_photos", nullable = false, length = 50)
    private String customerDeliveriesPhotos;

    @Column(name = "colleague_posts_shared", nullable = false)
    private Integer colleaguePostsShared;

    @Column(name = "customer_trade_ins_photos", nullable = false, length = 50)
    private String customerTradeInsPhotos;

    @Column(name = "shared_content_found", nullable = false, length = 50)
    private String sharedContentFound;

    @Column(name = "new_cars_leads")
    private Integer newCarsLeads;

    @Column(name = "pre_owned_leads")
    private Integer preOwnedLeads;

    @Column(name = "new_vehicles_delivered")
    private Integer newVehiclesDelivered;

    @Column(name = "new_vehicles_leased")
    private Integer newVehiclesLeased;

    @Column(name = "personal_average_ssi", precision = 10, scale = 2)
    private BigDecimal personalAverageSsi;

    @Column(name = "new_vehicle_last_sale_day", length = 50)
    private String newVehicleLastSaleDay;

    @Column(name = "pre_owned_vehicles_delivered")
    private Integer preOwnedVehiclesDelivered;

    @Column(name = "dp_finals_sold")
    private Integer dpFinalsSold;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "formulario_id")
    private Formulario formulario;

    @OneToMany(mappedBy = "formularioEndOfDay", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FacebookMarketPlace> facebookMarketPlaceEntries;

    @OneToMany(mappedBy = "formularioEndOfDay", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CrmProspect> crmProspects;

}