package com.surveyplatform.app.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.surveyplatform.app.dto.forms.HttpErrorInfoDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
public class FormatUtils {

    private FormatUtils(){}

    public static String httpErrorInfoFormatted(HttpStatus status, HttpServletRequest request, Exception ex) {
        var objectMapper = new ObjectMapper();
        var path = request.getRequestURI();
        var message = ex.getMessage();
        var httpErrorInfoDto = new HttpErrorInfoDto(status, path, message);

        try {
            return objectMapper.writeValueAsString(httpErrorInfoDto);
        } catch (JsonProcessingException e) {
            log.error("Error serializing HttpErrorInfoDto", e);
            return "{message: \"Error serializing HttpErrorInfoDto\"}";
        }
    }
}
