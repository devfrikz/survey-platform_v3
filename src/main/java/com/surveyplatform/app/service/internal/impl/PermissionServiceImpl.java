package com.surveyplatform.app.service.internal.impl;

import com.surveyplatform.app.dto.internal.PermisoDto;
import com.surveyplatform.app.mapper.PermissionMapper;
import com.surveyplatform.app.persistance.entities.internal.manytomany.RolPermiso;
import com.surveyplatform.app.persistance.repository.internal.PermissionRepository;
import com.surveyplatform.app.persistance.repository.internal.RolePermissionRepository;
import com.surveyplatform.app.service.internal.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;
    private final RolePermissionRepository rolePermissionRepository;
    @Override
    public void save(PermisoDto permisoDto) {
        var permission = PermissionMapper.MAPPER.toEntity(permisoDto);
        var permissionSaved = permissionRepository.save(permission);
        rolePermissionRepository.save(RolPermiso.builder()
                        .permisoId(permissionSaved.getId())
                        .rolId(permisoDto.getRoleId())
                .build());
    }
}
