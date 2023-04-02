package com.kata.board.dto

import java.time.LocalDateTime

data class PostDto(
    val id: Long? = null,
    val title: String,
    val userName: String? = null,
    val createdDate: LocalDateTime? = null,
    var content: String? = null,
    var view: Int? = null,
)