package com.surveyplatform.app.persistance.repository;

import com.surveyplatform.app.persistance.entities.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Pais, Long> {
}
