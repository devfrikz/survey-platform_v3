package com.surveyplatform.app.persistance.repository;

import com.surveyplatform.app.persistance.entities.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
}
