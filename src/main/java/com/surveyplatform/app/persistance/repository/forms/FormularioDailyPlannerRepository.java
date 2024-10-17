package com.surveyplatform.app.persistance.repository.forms;

import com.surveyplatform.app.persistance.entities.forms.FormularioDailyPlanner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormularioDailyPlannerRepository extends JpaRepository<FormularioDailyPlanner, Integer> {
}