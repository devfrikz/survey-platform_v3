package com.surveyplatform.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserDto {
    private String username;
    private String password;
    private String email;
    private String nombreCompleto;
    private Long sucursalId;
    private Long moduloId;
    private Long rolId;
    private boolean activo;
}
