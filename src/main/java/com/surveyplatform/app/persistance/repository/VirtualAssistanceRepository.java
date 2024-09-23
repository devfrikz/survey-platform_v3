package com.surveyplatform.app.persistance.repository;

import com.surveyplatform.app.persistance.entities.FormularioVirtualAssistance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VirtualAssistanceRepository extends JpaRepository<FormularioVirtualAssistance, Long> {
}
