package com.surveyplatform.app.service;

import com.surveyplatform.app.dto.RoleDto;

import java.util.List;

public interface RoleService {
    List<RoleDto> findAll();

    void saveRole(RoleDto role);
}
