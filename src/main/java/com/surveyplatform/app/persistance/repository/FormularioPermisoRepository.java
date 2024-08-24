package com.surveyplatform.app.persistance.repository;

import com.surveyplatform.app.persistance.entities.FormularioPermiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormularioPermisoRepository extends JpaRepository<FormularioPermiso, Long> {
}