package com.kata.board.post.service.request

import jakarta.validation.constraints.NotBlank

data class PostUpdateRequest(
    @field: NotBlank(message = "제목은 비어있을 수 없습니다.") val title: String,
    @field: NotBlank(message = "내용은 비어있을 수 없습니다.") val content: String
)
