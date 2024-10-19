package com.surveyplatform.app.mapper;

import com.surveyplatform.app.dto.internal.PermisoDto;
import com.surveyplatform.app.persistance.entities.internal.Permiso;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PermissionMapper {

    PermissionMapper MAPPER = Mappers.getMapper(PermissionMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "nombre", source = "name")
    @Mapping(target = "descripcion", source = "description")
    Permiso toEntity(PermisoDto permisoDto);
}
