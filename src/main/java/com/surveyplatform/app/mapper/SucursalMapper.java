package com.surveyplatform.app.mapper;

import com.surveyplatform.app.dto.internal.SucursalDto;
import com.surveyplatform.app.persistance.entities.internal.Sucursal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SucursalMapper {
    SucursalMapper MAPPER = Mappers.getMapper(SucursalMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pais", ignore = true)
    @Mapping(target = "ciudad", ignore = true)
    Sucursal toEntity(SucursalDto sucursalDto);

    @Mapping(target = "pais", source = "pais.id")
    @Mapping(target = "ciudad", source = "ciudad.id")
    SucursalDto toDto(Sucursal sucursal);
}
