package com.kata.board.dto

import com.kata.board.entity.Post
import jakarta.persistence.Entity
import java.time.LocalDateTime


data class PostDto (
    val id: Long? = null,
    val title: String = "",
    val createdDate: LocalDateTime? = null,
    val modifiedDate: LocalDateTime? = null,
    var content: String = "",
    var view: Int? = null,
) {
    fun convertPostDtoFromPost(): Post {
        return Post(
            id = this.id,
            title = this.title,
            content = this.content,
            )
    }
}