package com.surveyplatform.app.persistance.repository.forms;

import com.surveyplatform.app.persistance.entities.forms.FormularioReferenciado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormularioReferenciadoRepository extends JpaRepository<FormularioReferenciado, Integer> {
}