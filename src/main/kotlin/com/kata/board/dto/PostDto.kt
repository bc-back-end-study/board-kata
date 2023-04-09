package com.kata.board.dto

import java.time.LocalDateTime

data class PostDto(
    val id: Long,
    val title: String,
    val createdDate: LocalDateTime? = null,
    var content: String,
    var view: Int? = null,
)