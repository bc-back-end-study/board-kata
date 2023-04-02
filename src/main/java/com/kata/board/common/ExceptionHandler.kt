package com.kata.board.common

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.StringBuilder

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentNotValidException(e: MethodArgumentNotValidException): ResponseEntity<CommonResponse<Void>> {
        val builder = StringBuilder()
        for (fieldError in e.fieldErrors) {
            builder.append(fieldError.defaultMessage)
        }

        return ResponseEntity.badRequest().body(CommonResponse.badRequest(builder.toString()))
    }
}
