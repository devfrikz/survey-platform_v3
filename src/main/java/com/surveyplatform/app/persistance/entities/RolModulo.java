package com.surveyplatform.app.persistance.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rol_modulo", schema = "seguridad")
public class RolModulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "rol_id", referencedColumnName = "id")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "modulo_id", referencedColumnName = "id")
    private Modulo modulo;
}
