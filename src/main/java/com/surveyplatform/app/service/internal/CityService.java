package com.surveyplatform.app.service.internal;

import com.surveyplatform.app.dto.internal.CityDto;

import java.util.List;

public interface CityService {
    List<CityDto> findByCountryId(Long countryId);
}
