package com.surveyplatform.app.persistance.repository;

import com.surveyplatform.app.persistance.entities.FormularioVirtualAssistant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormularioVirtualAssistantRepository extends JpaRepository<FormularioVirtualAssistant, Long> {
}
