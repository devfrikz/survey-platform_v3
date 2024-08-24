package com.surveyplatform.app.exception;

import java.io.Serial;

public class SurveyPlatformException extends RuntimeException {

	@Serial
    private static final long serialVersionUID = 1L;
    private final String message;
    private final Integer code;

	public SurveyPlatformException(String message, Integer code) {
        super();
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
