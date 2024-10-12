package com.surveyplatform.app.service.impl;

import com.surveyplatform.app.dto.ModuleDto;
import com.surveyplatform.app.mapper.ModuleMapper;
import com.surveyplatform.app.persistance.repository.ModuleRepository;
import com.surveyplatform.app.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;

    @Override
    public List<ModuleDto> findAll() {
        var modules = moduleRepository.findAll();
        return modules.stream().map(ModuleMapper.MAPPER::toDto).toList();
    }
}
