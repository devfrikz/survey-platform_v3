package com.surveyplatform.app.persistance.repository.forms;

import com.surveyplatform.app.persistance.entities.forms.FormularioVirtualAssistant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormularioVirtualAssistantRepository extends JpaRepository<FormularioVirtualAssistant, Long> {
}
