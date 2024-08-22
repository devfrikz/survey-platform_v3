package com.surveyplatform.app.service;

import com.surveyplatform.app.dto.FormularioDto;
import com.surveyplatform.app.mapper.FormApprovalMapper;
import com.surveyplatform.app.persistance.entities.FormularioRespuesta;
import com.surveyplatform.app.persistance.repository.FormApprovalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FormApprovalService {

    private final FormApprovalRepository formApprovalRepository;

    public List<FormularioDto> obtenerFormulariosPendientes() { //TODO paginar
        List<FormularioRespuesta> formularios = formApprovalRepository.findAll();

        var listDto = formularios.stream().map(FormApprovalMapper.MAPPER::toDto).toList();

        listDto.forEach(formularioDto -> {//TODO revisar modelo
            formularioDto.setFechaEnvio(LocalDate.now());
            formularioDto.setEmpleado("John Doe");
        });

        return listDto;
    }

}
