package com.surveyplatform.app.persistance.repository.internal;

import com.surveyplatform.app.persistance.entities.internal.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
}
