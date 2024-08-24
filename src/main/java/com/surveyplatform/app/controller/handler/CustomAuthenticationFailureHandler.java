package com.surveyplatform.app.controller.handler;

import com.surveyplatform.app.dto.HttpErrorInfoDto;
import com.surveyplatform.app.utils.FormatUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;

@Component
@Slf4j
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    public static final String STATUS = "status";
    public static final String ERROR = "error";
    public static final String MESSAGE = "message";

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
            throws IOException {

        HttpErrorInfoDto httpErrorInfoJson = FormatUtils.httpErrorInfoFormatted(HttpStatus.FORBIDDEN, request, exception);
        log.error(httpErrorInfoJson.toString());
        log.error(Arrays.toString(exception.getStackTrace()));

        request.setAttribute(STATUS, HttpStatus.INTERNAL_SERVER_ERROR);
        request.setAttribute(ERROR, exception.getMessage());
        request.setAttribute(MESSAGE, exception.getMessage());

        request.setAttribute("exception", exception);
        response.sendRedirect("/survey-platform/login?error=true");
    }
}

