package com.surveyplatform.app.service;

import com.surveyplatform.app.dto.SucursalDto;

import java.util.List;

public interface SucursalService {
    void saveSucursal(SucursalDto sucursalDto);

    List<SucursalDto> findAll();
}
