package com.surveyplatform.app.persistance.repository;

import com.surveyplatform.app.persistance.entities.FormularioGeneralManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormularioGeneralManagementRepository extends JpaRepository<FormularioGeneralManagement, Long> {
}
