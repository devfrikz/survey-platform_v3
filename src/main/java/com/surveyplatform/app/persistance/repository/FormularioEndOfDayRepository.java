package com.surveyplatform.app.persistance.repository;

import com.surveyplatform.app.persistance.entities.FormularioEndOfDay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormularioEndOfDayRepository extends JpaRepository<FormularioEndOfDay, Integer> {
}