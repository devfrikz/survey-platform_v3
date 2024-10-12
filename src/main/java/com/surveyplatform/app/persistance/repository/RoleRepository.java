package com.surveyplatform.app.persistance.repository;

import com.surveyplatform.app.persistance.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Rol, Long> {
}
