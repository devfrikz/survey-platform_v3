package com.surveyplatform.app.persistance.repository.forms;

import com.surveyplatform.app.persistance.entities.forms.FormularioDeliveryChecklist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormularioDeliveryChecklistRepository extends JpaRepository<FormularioDeliveryChecklist, Integer> {
}