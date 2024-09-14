package com.surveyplatform.app.persistance.entities.manytomany;

import com.surveyplatform.app.persistance.entities.Rol;
import com.surveyplatform.app.persistance.entities.Usuario;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "usuario_rol", schema = "seguridad")
public class UsuarioRol {
    @EmbeddedId
    private UsuarioRolId id;

    @MapsId("usuarioId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @MapsId("rolId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rol;

}