package com.surveyplatform.app.controller.handler;

import com.surveyplatform.app.utils.FormatUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

@Component
@Slf4j
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    public static final String STATUS = "status";
    public static final String ERROR = "error";
    public static final String MESSAGE = "message";

    @SneakyThrows
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) {

        HttpStatus status;
        if(exception instanceof UsernameNotFoundException) {
            status = HttpStatus.NOT_FOUND;
        } else {
            status = HttpStatus.FORBIDDEN;
        }

        var message = exception.getMessage();
        var httpErrorInfoJson = FormatUtils.httpErrorInfoFormatted(status, request, exception);
        log.error(httpErrorInfoJson);
        log.error(Arrays.toString(exception.getStackTrace()));

        log.info(STATUS + ": " + status);
        log.info(MESSAGE + ": " + message);

        response.sendRedirect("/survey-platform/login?error=true&message=" + message + "&status=" + status);
    }
}

