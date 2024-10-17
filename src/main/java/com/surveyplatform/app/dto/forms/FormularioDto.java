package com.surveyplatform.app.dto.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class FormularioDto {
    private int id;
    private String tipo;
    private String empleado;
    private LocalDate fechaEnvio;
    private String modulo;
    private Boolean estado;
}
