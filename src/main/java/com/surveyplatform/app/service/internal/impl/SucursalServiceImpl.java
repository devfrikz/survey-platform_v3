package com.surveyplatform.app.service.internal.impl;

import com.surveyplatform.app.dto.internal.SucursalDto;
import com.surveyplatform.app.exception.SurveyPlatformException;
import com.surveyplatform.app.mapper.SucursalMapper;
import com.surveyplatform.app.persistance.repository.internal.CityRepository;
import com.surveyplatform.app.persistance.repository.internal.CountryRepository;
import com.surveyplatform.app.persistance.repository.internal.SucursalRepository;
import com.surveyplatform.app.service.internal.SucursalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SucursalServiceImpl implements SucursalService {

    private final SucursalRepository sucursalRepository;
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    @Override
    public void saveSucursal(SucursalDto sucursalDto) {
        var sucursal = SucursalMapper.MAPPER.toEntity(sucursalDto);
        var country = countryRepository.findById(sucursalDto.getPais()).orElseThrow(() -> new SurveyPlatformException("Country not found", 404));
        var city = cityRepository.findById(sucursalDto.getCiudad()).orElseThrow(() -> new SurveyPlatformException("City not found", 404));

        sucursal.setPais(country);
        sucursal.setCiudad(city);
        sucursalRepository.save(sucursal);
    }

    @Override
    public List<SucursalDto> findAll() {
        var sucursales = sucursalRepository.findAll();
        return sucursales.stream().map(SucursalMapper.MAPPER::toDto).toList();
    }
}
