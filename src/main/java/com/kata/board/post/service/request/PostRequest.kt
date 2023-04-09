package com.kata.board.post.service.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class PostRequest(
    @field:NotBlank(message = "제목은 null 일 수 없습니다.")
    val title: String? = null,

    @field:NotBlank(message = "내용은 null 일 수 없습니다.")
    val content: String? = null,

    @field:NotNull(message = "유저 id는 필수 값입니다.")
    val userId: Long? = null
)
