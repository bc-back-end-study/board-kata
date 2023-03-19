package com.kata.board.post.service.response

import java.time.LocalDate

class PagingResponse(
    val id: Long,
    val title: String,
    val content: String,
    val username: String,
    val viewCount: Int,
    val createdDate: LocalDate
) {
}
