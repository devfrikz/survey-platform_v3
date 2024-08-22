package com.surveyplatform.app.persistance.repository;

import com.surveyplatform.app.persistance.entities.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Modulo, Long> {
}
