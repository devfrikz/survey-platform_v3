package com.surveyplatform.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class SubmittedFormDto {
    private String formType;
    private String permisoFecha;
    private Integer permisoDuracion;
    private BigDecimal creditoAmount;
    private String creditoCliente;
    private BigDecimal descuentoPorcentaje;
    private String descuentoRazon;
    private String nombreClienteReferenciado;
    private String emailClienteReferenciado;
}
