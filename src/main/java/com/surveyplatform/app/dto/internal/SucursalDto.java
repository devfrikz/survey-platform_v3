package com.surveyplatform.app.dto.internal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class SucursalDto {
    private Long id;
    private String nombre;
    private String direccion;
    private Long pais;
    private Long ciudad;
}
