package com.surveyplatform.app.service;

import com.surveyplatform.app.dto.ModuleDto;

import java.util.List;

public interface ModuleService {
    List<ModuleDto> findAll();
}
