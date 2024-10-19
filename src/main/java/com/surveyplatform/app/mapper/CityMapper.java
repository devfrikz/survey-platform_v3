package com.surveyplatform.app.mapper;

import com.surveyplatform.app.dto.internal.CityDto;
import com.surveyplatform.app.persistance.entities.internal.Ciudad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CityMapper {

    CityMapper MAPPER = Mappers.getMapper(CityMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "nombre")
    CityDto toDto(Ciudad ciudad);
}
