package com.surveyplatform.app.persistance.repository;

import com.surveyplatform.app.persistance.entities.FormularioGeneralManagement;
import com.surveyplatform.app.persistance.entities.FormularioGeneralSalesManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormularioGeneralSalesManagerRepository extends JpaRepository<FormularioGeneralSalesManager, Long> {
}
