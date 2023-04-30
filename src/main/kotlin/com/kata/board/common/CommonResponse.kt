package com.kata.board.common

import org.springframework.http.HttpStatus

data class CommonResponse<T>(
    val status: Int? = null,
    val message: String? = null,
    val data: T? = null
) {
    companion object {
        fun badRequest(message: String) = CommonResponse<Void>(HttpStatus.BAD_REQUEST.value(), message, null)
    }
}
