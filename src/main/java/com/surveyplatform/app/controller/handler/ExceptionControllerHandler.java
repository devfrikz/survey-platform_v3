package com.surveyplatform.app.controller.handler;

import com.surveyplatform.app.exception.SurveyPlatformException;
import com.surveyplatform.app.utils.FormatUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@RestControllerAdvice
@Slf4j
public class ExceptionControllerHandler {

    public static final String STATUS = "status";
    public static final String ERROR = "error";
    public static final String MESSAGE = "message";

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public ModelAndView handleException(Exception exception, HttpServletRequest request) {
        var httpErrorInfoDto = FormatUtils.httpErrorInfoFormatted(HttpStatus.INTERNAL_SERVER_ERROR, request, exception);
        var modelAndView = new ModelAndView(ERROR);

        log.error(httpErrorInfoDto);
        log.error("Exception occurred", exception);

        modelAndView.addObject(STATUS, Objects.requireNonNull(modelAndView.getStatus()).value());
        modelAndView.addObject(MESSAGE, exception.getMessage());

        return modelAndView;
    }

    @ExceptionHandler(value = {SurveyPlatformException.class})
    @ResponseBody
    public ModelAndView handleServiceException(SurveyPlatformException exception, HttpServletRequest request) {
        var httpErrorInfoDto = "";
        var modelAndView = new ModelAndView(ERROR);

        switch (exception.getCode()) {
            case 400 -> {
                httpErrorInfoDto = FormatUtils.httpErrorInfoFormatted(HttpStatus.BAD_REQUEST, request, exception);
                modelAndView.setStatus(HttpStatus.BAD_REQUEST);
            }
            case 404 -> {
                httpErrorInfoDto = FormatUtils.httpErrorInfoFormatted(HttpStatus.NOT_FOUND, request, exception);
                modelAndView.setStatus(HttpStatus.NOT_FOUND);
            }
            default -> {
                httpErrorInfoDto = FormatUtils.httpErrorInfoFormatted(HttpStatus.INTERNAL_SERVER_ERROR, request, exception);
                modelAndView.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        log.error(httpErrorInfoDto);
        log.error("Exception occurred", exception);

        modelAndView.addObject(STATUS, Objects.requireNonNull(modelAndView.getStatus()).value());
        modelAndView.addObject(MESSAGE, exception.getMessage());

        return modelAndView;
    }


}
