package com.surveyplatform.app.mapper;

import com.surveyplatform.app.dto.FormularioDto;
import com.surveyplatform.app.persistance.entities.FormularioRespuesta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;

@Mapper(componentModel = "spring")
public interface FormApprovalMapper {

    FormApprovalMapper MAPPER = Mappers.getMapper(FormApprovalMapper.class);

    @Mappings({
            @Mapping(source = "formulario.modulo.nombre", target = "modulo"),
            @Mapping(source = "formulario.tipo.tipo", target = "tipo"),
            @Mapping(source = "aprobado", target = "estado"),
            @Mapping(source = "createdAt", target = "fechaEnvio", qualifiedByName = "mapTimestampToLocalDate"),
            @Mapping(source = "usuario.nombreCompleto", target = "empleado")
    })
    FormularioDto toDto(FormularioRespuesta model);

    @Mappings({
            @Mapping(source = "modulo", target = "formulario.modulo.nombre"),
            @Mapping(source = "tipo", target = "formulario.tipo.tipo"),
            @Mapping(source = "estado", target = "aprobado"),
            @Mapping(source = "fechaEnvio", target = "createdAt", qualifiedByName = "mapLocalDateToTimestamp"),
            @Mapping(source = "empleado", target = "usuario.nombreCompleto")
    })
    FormularioRespuesta toEntity(FormularioDto dto);

    @Named("mapTimestampToLocalDate")
    static LocalDate mapTimestampToLocalDate(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }
        return timestamp.toLocalDateTime().toLocalDate();
    }

    @Named("mapLocalDateToTimestamp")
    static Timestamp mapLocalDateToTimestamp(LocalDate localDate) {
        if (localDate == null) {
            return null;
        }
        return Timestamp.valueOf(localDate.atStartOfDay());
    }
}

