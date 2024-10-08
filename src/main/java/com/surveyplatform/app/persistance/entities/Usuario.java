package com.surveyplatform.app.persistance.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
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
    private String sucursalId;
    @Column(name = "rol_id")
    private String rolId;
    private Boolean activo;

}
