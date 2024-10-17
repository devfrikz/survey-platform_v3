package com.surveyplatform.app.controller.rest;

import com.surveyplatform.app.dto.internal.CityDto;
import com.surveyplatform.app.service.internal.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CityRestController {

    private final CityService cityService;
    @GetMapping("/cities")
    public ResponseEntity<List<CityDto>> getCitiesByCountry(@RequestParam("countryId") Long countryId) {
        List<CityDto> cities = cityService.findByCountryId(countryId);
        return ResponseEntity.ok(cities);
    }
}
