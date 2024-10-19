package com.surveyplatform.app.persistance.entities.internal.manytomany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRolId implements Serializable {

    private Long rolId;
    private Long usuarioId;
}

