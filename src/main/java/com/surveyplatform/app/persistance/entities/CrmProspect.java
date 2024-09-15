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
@Table(name = "crm_prospect", schema = "crm")
public class CrmProspect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prospect_first_name")
    private String prospectFirstName;
    @Column(name = "prospect_last_name")
    private String prospectLastName;
    @Column(name = "crm_customer_number")
    private Integer crmCustomerNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formulario_end_of_day_id", nullable = false)
    private FormularioEndOfDay formularioEndOfDay;
}
