package com.surveyplatform.app.persistance.repository.internal;

import com.surveyplatform.app.persistance.entities.internal.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Pais, Long> {
}
