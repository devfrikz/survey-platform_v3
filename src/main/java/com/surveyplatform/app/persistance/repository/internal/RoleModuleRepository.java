package com.surveyplatform.app.persistance.repository.internal;

import com.surveyplatform.app.persistance.entities.internal.manytomany.RolModulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleModuleRepository extends JpaRepository<RolModulo, Long> {
}
