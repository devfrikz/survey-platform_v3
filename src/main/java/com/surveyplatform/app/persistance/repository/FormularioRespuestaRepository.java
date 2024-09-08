package com.surveyplatform.app.persistance.repository;

import com.surveyplatform.app.persistance.entities.FormularioRespuesta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FormularioRespuestaRepository extends JpaRepository<FormularioRespuesta, Long> {

    // Usar una consulta JPQL para filtrar por sucursal y lista de IDs de roles
    @Query("SELECT fr FROM FormularioRespuesta fr " +
            "JOIN fr.usuario u " +
            "JOIN u.roles r " +
            "WHERE fr.sucursal.id = :sucursalId AND r.id IN :roleIds")
    Page<FormularioRespuesta> findBySucursalIdAndRoleIds(@Param("sucursalId") Long sucursalId, @Param("roleIds") List<Long> roleIds, Pageable pageable);
}
