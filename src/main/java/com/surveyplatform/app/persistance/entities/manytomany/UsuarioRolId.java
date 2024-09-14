package com.surveyplatform.app.persistance.entities.manytomany;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class UsuarioRolId implements Serializable {
    private static final long serialVersionUID = -5910759703631392860L;
    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;

    @Column(name = "rol_id", nullable = false)
    private Integer rolId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UsuarioRolId entity = (UsuarioRolId) o;
        return Objects.equals(this.rolId, entity.rolId) &&
                Objects.equals(this.usuarioId, entity.usuarioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rolId, usuarioId);
    }

}