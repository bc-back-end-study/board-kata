package com.kata.board.dto

import java.time.LocalDateTime

data class PostDto(
    val id: Long,
    val title: String,
    val userName: String,
    val createdDate: LocalDateTime,
    var content: String,
    var view: Int,
)