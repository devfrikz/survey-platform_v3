package com.surveyplatform.app.mapper;

import com.surveyplatform.app.dto.internal.ModuleDto;
import com.surveyplatform.app.persistance.entities.internal.Modulo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ModuleMapper {

    ModuleMapper MAPPER = Mappers.getMapper(ModuleMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "nombre")
    @Mapping(target = "description", source = "descripcion")
    ModuleDto toDto(Modulo module);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "nombre", source = "name")
    @Mapping(target = "descripcion", source = "description")
    Modulo toEntity(ModuleDto moduleDto);

}
