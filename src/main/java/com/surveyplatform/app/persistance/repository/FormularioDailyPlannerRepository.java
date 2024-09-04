package com.surveyplatform.app.persistance.repository;

import com.surveyplatform.app.persistance.entities.FormularioDailyPlanner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormularioDailyPlannerRepository extends JpaRepository<FormularioDailyPlanner, Integer> {
}