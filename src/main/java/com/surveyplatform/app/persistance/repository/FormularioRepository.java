package com.surveyplatform.app.persistance.repository;

import com.surveyplatform.app.persistance.entities.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormularioRepository extends JpaRepository<Formulario, Long> {
}