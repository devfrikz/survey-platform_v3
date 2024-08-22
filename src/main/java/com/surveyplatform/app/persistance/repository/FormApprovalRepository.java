package com.surveyplatform.app.persistance.repository;

import com.surveyplatform.app.persistance.entities.FormularioRespuesta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormApprovalRepository extends JpaRepository<FormularioRespuesta, Long> {
}
