package com.kata.board.post.service.response

import java.time.LocalDate

data class PagingResponse(
    val id: Long? = null,
    val title: String? = null,
    val content: String? = null,
    val username: String? = null,
    val viewCount: Int? = null,
    val createdDate: LocalDate? = null
)
