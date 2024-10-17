package com.surveyplatform.app.service.impl;

import com.surveyplatform.app.dto.RoleDto;
import com.surveyplatform.app.mapper.RoleMapper;
import com.surveyplatform.app.persistance.repository.RoleRepository;
import com.surveyplatform.app.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    @Override
    public List<RoleDto> findAll() {
        var roles = roleRepository.findAll();
        return roles.stream().map(RoleMapper.MAPPER::toDto).toList();
    }

    @Override
    public void saveRole(RoleDto roleDto) {
        var roleEntity = RoleMapper.MAPPER.toEntity(roleDto);
        roleRepository.save(roleEntity);
    }
}
