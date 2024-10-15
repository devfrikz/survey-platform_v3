package com.surveyplatform.app.mapper;

import com.surveyplatform.app.dto.RoleDto;
import com.surveyplatform.app.persistance.entities.Rol;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {
    RoleMapper MAPPER = Mappers.getMapper(RoleMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "nombre", source = "name")
    @Mapping(target = "descripcion", source = "description")
    Rol toEntity(RoleDto roleDto);
    @Mapping(target = "name", source = "nombre")
    @Mapping(target = "description", source = "descripcion")
    RoleDto toDto(Rol role);
}
