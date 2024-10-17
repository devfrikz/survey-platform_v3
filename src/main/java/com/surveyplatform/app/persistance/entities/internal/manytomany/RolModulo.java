package com.surveyplatform.app.persistance.entities.internal.manytomany;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rol_modulo", schema = "seguridad")
@IdClass(RolModuloId.class)
public class RolModulo {

        @Id
        @Column(name = "rol_id")
        private Long rolId;

        @Id
        @Column(name = "modulo_id")
        private Long moduloId;
}
