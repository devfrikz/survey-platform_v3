package com.surveyplatform.app.service.internal;

import com.surveyplatform.app.dto.internal.ModuleDto;

import java.util.List;

public interface ModuleService {
    List<ModuleDto> findAll();

    void save(ModuleDto moduleDto);
}
