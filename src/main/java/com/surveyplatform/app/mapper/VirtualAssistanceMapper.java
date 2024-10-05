package com.surveyplatform.app.mapper;

import com.surveyplatform.app.dto.VirtualAssistanceDto;
import com.surveyplatform.app.persistance.entities.FormularioFinanceDirector;
import com.surveyplatform.app.persistance.entities.FormularioGeneralManagement;
import com.surveyplatform.app.persistance.entities.FormularioGeneralSalesManager;
import com.surveyplatform.app.persistance.entities.FormularioInternetSalesManager;
import com.surveyplatform.app.persistance.entities.FormularioNewCarSalesManager;
import com.surveyplatform.app.persistance.entities.FormularioSalesManagerPreOwned;
import com.surveyplatform.app.persistance.entities.FormularioVirtualAssistant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VirtualAssistanceMapper {

    VirtualAssistanceMapper MAPPER = Mappers.getMapper(VirtualAssistanceMapper.class);

    @Mapping(target = "id", ignore = true)
    FormularioGeneralManagement toEntityFormularioGeneralManagement(VirtualAssistanceDto dto);

    @Mapping(target = "id", ignore = true)
    FormularioVirtualAssistant toEntityFormularioVirtualAssistant(VirtualAssistanceDto dto);

    @Mapping(target = "id", ignore = true)
    FormularioGeneralSalesManager toEntityFormularioGeneralSalesManager(VirtualAssistanceDto dto);

    @Mapping(target = "id", ignore = true)
    FormularioNewCarSalesManager toEntityNewCarSalesManager(VirtualAssistanceDto dto);

    @Mapping(target = "id", ignore = true)
    FormularioSalesManagerPreOwned toEntityFormularioSalesManagerPreOwned(VirtualAssistanceDto virtualAssistanceDto);

    @Mapping(target = "id", ignore = true)
    FormularioFinanceDirector toEntityFormularioFinanceDirector(VirtualAssistanceDto virtualAssistanceDto);

    @Mapping(target = "id", ignore = true)
    FormularioInternetSalesManager toEntityFormularioInternetSalesManager(VirtualAssistanceDto virtualAssistanceDto);
}
