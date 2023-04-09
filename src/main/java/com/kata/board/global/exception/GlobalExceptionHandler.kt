package com.kata.board.global.exception

import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.StringBuilder

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler
    fun runtimeException(e: MethodArgumentNotValidException, response: HttpServletResponse): ResponseEntity<Map<String, String?>> {

        val builder = StringBuilder()
        for (error in e.bindingResult.allErrors) {
            builder.append(error.defaultMessage)
        }
        val mapOf = mapOf(
            "errorMessage" to builder.toString()
        )
        return ResponseEntity.badRequest().body(mapOf)
    }
}
