package com.surveyplatform.app.controller.handler;

import com.surveyplatform.app.dto.HttpErrorInfoDto;
import com.surveyplatform.app.exception.SurveyPlatformException;
import com.surveyplatform.app.utils.FormatUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.Arrays;

@RestControllerAdvice
@Slf4j
public class ExceptionControllerHandler {

    public static final String STATUS = "status";
    public static final String ERROR = "error";
    public static final String MESSAGE = "message";
    public static final String URL_ERROR = "/survey-platform/error";

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public void handleException(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpErrorInfoDto httpErrorInfoJson = FormatUtils.httpErrorInfoFormatted(HttpStatus.INTERNAL_SERVER_ERROR, request, exception);
        log.error(httpErrorInfoJson.toString());
        log.error(Arrays.toString(exception.getStackTrace()));

        request.setAttribute(STATUS, HttpStatus.INTERNAL_SERVER_ERROR);
        request.setAttribute(ERROR, exception.getCause().getMessage());
        request.setAttribute(MESSAGE, exception.getMessage());
        response.sendRedirect(URL_ERROR);
    }

    @ExceptionHandler(value = {SurveyPlatformException.class})
    @ResponseBody
    public void handleServiceException(SurveyPlatformException exception, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpErrorInfoDto httpErrorInfoJson;

        switch (exception.getCode()) {
            case 400 -> {
                httpErrorInfoJson = FormatUtils.httpErrorInfoFormatted(HttpStatus.BAD_REQUEST, request, exception);
                log.error(httpErrorInfoJson.toString());
                log.error(Arrays.toString(exception.getStackTrace()));
                request.setAttribute(STATUS, HttpStatus.BAD_REQUEST);
            }
            case 404 -> {
                httpErrorInfoJson = FormatUtils.httpErrorInfoFormatted(HttpStatus.NOT_FOUND, request, exception);
                log.error(httpErrorInfoJson.toString());
                log.error(Arrays.toString(exception.getStackTrace()));
                request.setAttribute(STATUS, HttpStatus.NOT_FOUND);
            }
            default -> {
                httpErrorInfoJson = FormatUtils.httpErrorInfoFormatted(HttpStatus.INTERNAL_SERVER_ERROR, request, exception);
                log.error(httpErrorInfoJson.toString());
                log.error(Arrays.toString(exception.getStackTrace()));
                request.setAttribute(STATUS, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        request.setAttribute(ERROR, exception.getCause().getMessage());
        request.setAttribute(MESSAGE, exception.getMessage());
        response.sendRedirect(URL_ERROR);
    }

}
