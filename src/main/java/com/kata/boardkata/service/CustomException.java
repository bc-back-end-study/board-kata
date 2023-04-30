package com.kata.boardkata.service;

import com.kata.boardkata.model.response.BaseStatusCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.logging.LogLevel;

@Getter
@Setter
public class CustomException extends RuntimeException {
    private BaseStatusCode baseStatusCode;
    private String exceptionMessage;
    private LogLevel logLevel;
    private Object body;

    public CustomException(BaseStatusCode baseStatusCode, LogLevel logLevel) {
        this(baseStatusCode, baseStatusCode.getMessage(), null, logLevel);
    }

    public CustomException(BaseStatusCode baseStatusCode, String exceptionMessage, Object body, LogLevel logLevel) {
        this.baseStatusCode = baseStatusCode;
        this.exceptionMessage = exceptionMessage;
        this.logLevel= logLevel;
        this.body = body;
    }
}