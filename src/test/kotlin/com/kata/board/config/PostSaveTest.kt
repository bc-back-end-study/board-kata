package com.kata.board.config

import com.kata.board.dto.PostDto
import com.kata.board.service.PostService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@SpringBootTest
class PostSaveTest (
    @Autowired private val postService: PostService,
) {
    @Test
    @DisplayName("게시글을 등록 했을 때 id값이 0보다 커야한다.")
    fun `Get Save Post Item`() {

        //given
        val poseDto = PostDto(
            id = 0L,
            title = "Test Title",
            content = "Test Content",
            createdDate = LocalDateTime.now(),
            modifiedDate = LocalDateTime.now(),
            view = 0
            )

        //when
        val result = postService.savePost(poseDto)

        //then
        assertThat(result.id).isGreaterThan(0L)
    }
}