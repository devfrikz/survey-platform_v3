package com.surveyplatform.app.persistance.entities.internal;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rol", schema = "seguridad")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
}