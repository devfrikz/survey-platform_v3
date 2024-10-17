package com.surveyplatform.app.persistance.repository.internal;

import com.surveyplatform.app.persistance.entities.internal.manytomany.RolPermiso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePermissionRepository extends JpaRepository<RolPermiso, Long> {
}
