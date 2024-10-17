package com.surveyplatform.app.persistance.repository.forms;

import com.surveyplatform.app.persistance.entities.forms.FormularioRespuesta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FormularioRespuestaRepository extends JpaRepository<FormularioRespuesta, Long> {

    @Query(value = "SELECT DISTINCT fr.* " +
            "FROM crm.formulario_respuesta fr " +
            "JOIN seguridad.usuario u ON fr.usuario_id = u.id " +
            "JOIN seguridad.usuario_rol ur ON u.id = ur.usuario_id " +
            "JOIN seguridad.rol r ON ur.rol_id = r.id " +
            "WHERE fr.sucursal_id = :sucursalId AND r.id IN :roleIds",
            countQuery = "SELECT COUNT(DISTINCT fr.id) " +
                    "FROM crm.formulario_respuesta fr " +
                    "JOIN seguridad.usuario u ON fr.usuario_id = u.id " +
                    "JOIN seguridad.usuario_rol ur ON u.id = ur.usuario_id " +
                    "JOIN seguridad.rol r ON ur.rol_id = r.id " +
                    "WHERE fr.sucursal_id = :sucursalId AND r.id IN :roleIds",
            nativeQuery = true)
    Page<FormularioRespuesta> findBySucursalIdAndRoleIds(@Param("sucursalId") Long sucursalId, @Param("roleIds") List<Long> roleIds, Pageable pageable);

}
