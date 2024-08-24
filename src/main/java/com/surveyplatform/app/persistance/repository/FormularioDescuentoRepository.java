package com.surveyplatform.app.persistance.repository;

import com.surveyplatform.app.persistance.entities.FormularioDescuento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormularioDescuentoRepository extends JpaRepository<FormularioDescuento, Integer> {
}