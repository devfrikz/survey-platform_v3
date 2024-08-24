package com.surveyplatform.app.persistance.repository;

import com.surveyplatform.app.persistance.entities.FormularioTipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormularioTipoRepository extends JpaRepository<FormularioTipo, Long> {
    Optional<FormularioTipo> findByTipoIgnoreCase(String formType);
}
