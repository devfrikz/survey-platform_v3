package com.surveyplatform.app.persistance.entities;

import com.surveyplatform.app.persistance.entities.manytomany.UsuarioRol;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rol", schema = "seguridad")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;

    // Relación ManyToMany con Modulo a través de la tabla intermedia rol_modulo
    @ManyToMany
    @JoinTable(
            name = "rol_modulo",
            joinColumns = @JoinColumn(name = "rol_id"),
            inverseJoinColumns = @JoinColumn(name = "modulo_id")
    )
    private Set<Modulo> modulos;

    // Relación ManyToMany con Permiso a través de la tabla intermedia rol_permiso
    @ManyToMany
    @JoinTable(
            name = "rol_permiso",
            joinColumns = @JoinColumn(name = "rol_id"),
            inverseJoinColumns = @JoinColumn(name = "permiso_id")
    )
    private Set<Permiso> permisos;
}
