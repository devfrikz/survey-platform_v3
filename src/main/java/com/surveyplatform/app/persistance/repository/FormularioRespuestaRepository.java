package com.surveyplatform.app.persistance.repository;

import com.surveyplatform.app.persistance.entities.FormularioRespuesta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormularioRespuestaRepository extends JpaRepository<FormularioRespuesta, Long> {
    // Método para filtrar las respuestas de formularios por sucursal y rol
    Page<FormularioRespuesta> findBySucursalIdAndUsuarioRolId(Long sucursalId, Long rolId, Pageable pageable);
}
