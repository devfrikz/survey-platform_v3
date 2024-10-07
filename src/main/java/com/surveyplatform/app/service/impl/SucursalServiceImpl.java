package com.surveyplatform.app.service.impl;

import com.surveyplatform.app.dto.SucursalDto;
import com.surveyplatform.app.exception.SurveyPlatformException;
import com.surveyplatform.app.mapper.SucursalMapper;
import com.surveyplatform.app.persistance.entities.Sucursal;
import com.surveyplatform.app.persistance.repository.CityRepository;
import com.surveyplatform.app.persistance.repository.CountryRepository;
import com.surveyplatform.app.persistance.repository.SucursalRepository;
import com.surveyplatform.app.service.SucursalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SucursalServiceImpl implements SucursalService {

    private final SucursalRepository sucursalRepository;
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    @Override
    public void saveSucursal(SucursalDto sucursalDto) {
        var sucursal = SucursalMapper.MAPPER.toEntity(sucursalDto);
        var country = countryRepository.findById(sucursalDto.getPais().longValue()).orElseThrow(() -> new SurveyPlatformException("Country not found", 404));
        var city = cityRepository.findById(sucursalDto.getCiudad().longValue()).orElseThrow(() -> new SurveyPlatformException("City not found", 404));

        sucursal.setPais(country);
        sucursal.setCiudad(city);
        sucursalRepository.save(sucursal);
    }
}
