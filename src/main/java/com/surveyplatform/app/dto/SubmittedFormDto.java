package com.surveyplatform.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class SubmittedFormDto {
    private String formType;
    private String permisoFecha;
    private Integer permisoDuracion;
    private Double creditoAmount;
    private String creditoCliente;
    private Integer descuentoPorcentaje;
    private String descuentoRazon;
    private String referralNombre;
    private String referralEmail;
}
