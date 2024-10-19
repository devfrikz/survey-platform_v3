package com.surveyplatform.app.persistance.repository.forms;

import com.surveyplatform.app.persistance.entities.forms.FormularioTipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormularioTipoRepository extends JpaRepository<FormularioTipo, Long> {
    Optional<FormularioTipo> findByTipoIgnoreCase(String formType);
}
