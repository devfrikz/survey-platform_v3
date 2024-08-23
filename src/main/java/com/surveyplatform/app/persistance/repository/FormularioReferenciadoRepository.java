package com.surveyplatform.app.persistance.repository;

import com.surveyplatform.app.persistance.entities.FormularioReferenciado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormularioReferenciadoRepository extends JpaRepository<FormularioReferenciado, Integer> {
}