package com.surveyplatform.app.mapper;

import com.surveyplatform.app.dto.VirtualAssistanceDto;
import com.surveyplatform.app.persistance.entities.FormularioVirtualAssistance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VirtualAssistanceMapper {

    VirtualAssistanceMapper MAPPER = Mappers.getMapper(VirtualAssistanceMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "romiReportAnalyzed", source = "romi")
    @Mapping(target = "correctiveActionSet", source = "correctiveAction")
    FormularioVirtualAssistance toEntity(VirtualAssistanceDto dto);

    VirtualAssistanceDto toDto(FormularioVirtualAssistance entity);
}
