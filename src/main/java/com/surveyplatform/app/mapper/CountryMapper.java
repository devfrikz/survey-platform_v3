package com.surveyplatform.app.mapper;

import com.surveyplatform.app.dto.internal.CountryDto;
import com.surveyplatform.app.persistance.entities.internal.Pais;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {

    CountryMapper MAPPER = Mappers.getMapper(CountryMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "nombre")
    @Mapping(target = "isoCode", source = "codigoIso")
    CountryDto toDto(Pais pais);
}
