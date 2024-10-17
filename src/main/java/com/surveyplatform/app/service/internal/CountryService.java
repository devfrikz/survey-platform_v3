package com.surveyplatform.app.service.internal;

import com.surveyplatform.app.dto.internal.CountryDto;

import java.util.List;

public interface CountryService {
    List<CountryDto> findAll();
}
