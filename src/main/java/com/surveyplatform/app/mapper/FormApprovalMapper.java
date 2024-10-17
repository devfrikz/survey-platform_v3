package com.surveyplatform.app.mapper;

import com.surveyplatform.app.dto.forms.FormularioDto;
import com.surveyplatform.app.persistance.entities.forms.FormularioRespuesta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.sql.Timestamp;
import java.time.LocalDate;

@Mapper(componentModel = "spring")
public interface FormApprovalMapper {

    FormApprovalMapper MAPPER = Mappers.getMapper(FormApprovalMapper.class);

    @Mappings({
            @Mapping(source = "formulario.modulo.nombre", target = "modulo"),
            @Mapping(source = "formulario.tipo.tipo", target = "tipo"),
            @Mapping(source = "aprobado", target = "estado"),
            @Mapping(source = "createdAt", target = "fechaEnvio", qualifiedByName = "mapTimestampToLocalDate"),
    })
    FormularioDto toDto(FormularioRespuesta model);

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

