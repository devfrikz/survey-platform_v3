package com.surveyplatform.app.service.internal;

import com.surveyplatform.app.dto.internal.SucursalDto;

import java.util.List;

public interface SucursalService {
    void saveSucursal(SucursalDto sucursalDto);

    List<SucursalDto> findAll();
}
