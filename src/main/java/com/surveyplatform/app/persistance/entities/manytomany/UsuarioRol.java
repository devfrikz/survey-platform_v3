package com.surveyplatform.app.persistance.entities.manytomany;

import com.surveyplatform.app.persistance.entities.Rol;
import com.surveyplatform.app.persistance.entities.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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