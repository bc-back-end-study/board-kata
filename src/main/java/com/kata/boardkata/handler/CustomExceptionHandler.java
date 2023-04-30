package com.kata.boardkata.handler;

import com.kata.boardkata.model.response.BaseResponse;
import com.kata.boardkata.service.CustomException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public BaseResponse handlerException(CustomException e) {
        return new BaseResponse(e.getBaseStatusCode(),e.getExceptionMessage(),e.getBody());
    }
}
