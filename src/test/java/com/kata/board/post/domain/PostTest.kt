package com.kata.board.post.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PostTest {

    @Test
    @DisplayName("게시글 업데이트")
    fun `Should update post When normal Request`() {
        val post = Post("title", "content")
        post.update("제목", "내용")
        assertThat(post.title).isEqualTo("제목")
        assertThat(post.content).isEqualTo("내용")
    }
}
