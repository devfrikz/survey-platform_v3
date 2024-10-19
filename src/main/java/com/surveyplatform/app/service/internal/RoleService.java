package com.surveyplatform.app.service.internal;

import com.surveyplatform.app.dto.internal.RoleDto;

import java.util.List;

public interface RoleService {
    List<RoleDto> findAll();

    void saveRole(RoleDto role);
}
