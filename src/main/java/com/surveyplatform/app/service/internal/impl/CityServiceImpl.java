package com.surveyplatform.app.service.internal.impl;

import com.surveyplatform.app.dto.internal.CityDto;
import com.surveyplatform.app.mapper.CityMapper;
import com.surveyplatform.app.persistance.repository.internal.CityRepository;
import com.surveyplatform.app.service.internal.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    @Override
    public List<CityDto> findByCountryId(Long countryId) {
        return cityRepository.findByCountryId(countryId).stream()
                .map(CityMapper.MAPPER::toDto)
                .toList();
    }
}
