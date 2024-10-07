package com.surveyplatform.app.persistance.repository;

import com.surveyplatform.app.persistance.entities.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<Ciudad, Long> {
}
