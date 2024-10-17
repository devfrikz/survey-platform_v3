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

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "formulario_delivery_checklist", schema = "crm")
public class FormularioDeliveryChecklist {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "stock", nullable = false, length = 50)
    private String stock;

    @Column(name = "vehicle", nullable = false)
    private String vehicle;

    @Column(name = "vehicle_type", nullable = false, length = 50)
    private String vehicleType;

    @Column(name = "copy_of")
    private String copyOf;

    @Column(name = "signed")
    private String signed;

    @Column(name = "title_plates")
    private String titlePlates;

    @Column(name = "deposit_amount", precision = 10, scale = 2)
    private BigDecimal depositAmount;

    @Column(name = "collected_by")
    private String collectedBy;

    @Column(name = "collected_date")
    private LocalDate collectedDate;

    @Column(name = "refund")
    private Boolean refund;

    @Column(name = "refunded_by")
    private String refundedBy;

    @Column(name = "refund_date")
    private LocalDate refundDate;

    @Column(name = "down_payment_amount", precision = 10, scale = 2)
    private BigDecimal downPaymentAmount;

    @Column(name = "total_collected", precision = 10, scale = 2)
    private BigDecimal totalCollected;

    @Column(name = "fi_initials", length = 50)
    private String fiInitials;

    @Column(name = "fi_date")
    private LocalDate fiDate;

    @Column(name = "sales_manager_checklist")
    private String salesManagerChecklist;

    @Column(name = "dom_castle_checklist")
    private String domCastleChecklist;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "formulario_id")
    private Formulario formulario;

}