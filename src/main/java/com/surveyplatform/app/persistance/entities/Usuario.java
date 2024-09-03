package com.surveyplatform.app.persistance.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario", schema = "seguridad")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String email;
    @Column(name = "nombre_completo")
    private String nombreCompleto;
    @Column(name = "sucursal_id")
    private Long sucursalId;
    @Column(name = "rol_id")
    private Long rolId;
    private Boolean activo;

}
