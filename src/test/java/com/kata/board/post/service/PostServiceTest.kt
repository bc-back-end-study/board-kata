package com.kata.board.post.service

import com.kata.board.post.domain.Post
import com.kata.board.post.repository.PostRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest

@SpringBootTest
class PostServiceTest(
    @Autowired private val postRepository: PostRepository,
    @Autowired private val postService: PostService
) {
    @Test
    @DisplayName("게시글 페이징 조회 시 정상 반환")
    fun `Should findAllPagenatedPost When getPostAll`() {
        //given
        postRepository.save(Post("제목", "내용"))

        //when
        val findAllPagenatedPost = postService.findAllPagenatedPost(PageRequest.of(0, 5))

        //then
        val result = findAllPagenatedPost.content[0]
        assertAll({
            assertThat(result.id).isEqualTo(1L)
            assertThat(result.title).isEqualTo("제목")
            assertThat(result.content).isEqualTo("내용")
            assertThat(result.viewCount).isZero
            assertThat(result.createdDate).isNotNull()
        })
    }
}


