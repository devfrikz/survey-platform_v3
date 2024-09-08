package com.surveyplatform.app.persistance.repository;

import com.surveyplatform.app.persistance.entities.Formulario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormularioRepository extends JpaRepository<Formulario, Long> {

    // Método para obtener los formularios filtrados por sucursal y rol
    Page<Formulario> findBySucursal_IdAndUsuario_Roles_Id(Long sucursalId, Long rolId, Pageable pageable);

}
