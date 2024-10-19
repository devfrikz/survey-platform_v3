package com.surveyplatform.app.persistance.repository.internal;

import com.surveyplatform.app.persistance.entities.internal.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<Ciudad, Long> {

    @Query("SELECT c FROM Ciudad c WHERE c.pais.id = ?1")
    List<Ciudad> findByCountryId(Long countryId);
}
