package com.surveyplatform.app.service.internal.impl;

import com.surveyplatform.app.dto.internal.ModuleDto;
import com.surveyplatform.app.mapper.ModuleMapper;
import com.surveyplatform.app.persistance.entities.internal.manytomany.RolModulo;
import com.surveyplatform.app.persistance.repository.internal.ModuleRepository;
import com.surveyplatform.app.persistance.repository.internal.RoleModuleRepository;
import com.surveyplatform.app.service.internal.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;
    private final RoleModuleRepository roleModuleRepository;

    @Override
    public List<ModuleDto> findAll() {
        var modules = moduleRepository.findAll();
        return modules.stream().map(ModuleMapper.MAPPER::toDto).toList();
    }

    @Override
    public void save(ModuleDto moduleDto) {
        var module = ModuleMapper.MAPPER.toEntity(moduleDto);
        var newModule = moduleRepository.save(module);
        roleModuleRepository.save(RolModulo.builder()
                .moduloId(newModule.getId())
                .rolId(moduleDto.getRoleId())
                .build());
    }
}
