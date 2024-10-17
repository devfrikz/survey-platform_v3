package com.surveyplatform.app.persistance.entities.internal.manytomany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
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
@Table(name = "usuario_rol", schema = "seguridad")
@IdClass(UsuarioRolId.class)
public class UsuarioRol {

    @Id
    @Column(name ="rol_id")
    private Long rolId;

    @Id
    @Column(name ="usuario_id")
    private Long usuarioId;

}