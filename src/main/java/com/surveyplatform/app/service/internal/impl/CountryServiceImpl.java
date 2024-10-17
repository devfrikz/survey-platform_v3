package com.surveyplatform.app.service.internal.impl;

import com.surveyplatform.app.dto.internal.CountryDto;
import com.surveyplatform.app.mapper.CountryMapper;
import com.surveyplatform.app.persistance.repository.internal.CountryRepository;
import com.surveyplatform.app.service.internal.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    @Override
    public List<CountryDto> findAll() {
        return countryRepository.findAll().stream().map(CountryMapper.MAPPER::toDto).toList();
    }
}
