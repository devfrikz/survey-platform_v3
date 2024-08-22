package com.surveyplatform.app.mapper;

import com.surveyplatform.app.dto.FormularioDto;
import com.surveyplatform.app.persistance.entities.Formulario;
import com.surveyplatform.app.persistance.entities.FormularioRespuesta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FormApprovalMapper {
    FormApprovalMapper MAPPER = Mappers.getMapper(FormApprovalMapper.class);

    @Mapping(source = "formulario.modulo.nombre", target = "modulo")
    @Mapping(source = "formulario.tipo.tipo", target = "tipo")
    @Mapping(source = "aprobado", target = "estado")
    FormularioDto toDto(FormularioRespuesta model);

    @Mapping(source = "modulo", target = "formulario.modulo.nombre")
    @Mapping(source = "tipo", target = "formulario.tipo.tipo")
    @Mapping(source = "estado", target = "aprobado")
    FormularioRespuesta toEntity(FormularioDto dto);
}
