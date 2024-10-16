package com.surveyplatform.app.persistance.entities.manytomany;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rol_permiso", schema = "seguridad")
@IdClass(RolPermisoId.class)
public class RolPermiso {

    @Id
    @Column(name = "rol_id")
    private Long rolId;

    @Id
    @Column(name = "permiso_id")
    private Long permisoId;
}
