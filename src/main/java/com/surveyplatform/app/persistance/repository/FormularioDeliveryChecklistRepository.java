package com.surveyplatform.app.persistance.repository;

import com.surveyplatform.app.persistance.entities.FormularioDeliveryChecklist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormularioDeliveryChecklistRepository extends JpaRepository<FormularioDeliveryChecklist, Integer> {
}