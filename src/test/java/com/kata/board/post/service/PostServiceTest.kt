package com.kata.board.post.service

import com.kata.board.post.domain.Post
import com.kata.board.post.repository.PostRepository
import com.kata.board.post.service.request.PostRequest
import com.kata.board.post.service.request.PostUpdateRequest
import com.kata.board.util.BoardBootTest
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest

class PostServiceTest(
    @Autowired private val postRepository: PostRepository,
    @Autowired private val postService: PostService,
): BoardBootTest() {

    @AfterEach
    fun clean() {
        cleanup!!.execute()
    }

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

    @Test
    @DisplayName("게시글 등록하기")
    fun `Should register post When user post registration request`() {
        //when
        postService.registerPost(PostRequest("title", "content", 1L))

        //then
        val post = postService.findAllPagenatedPost(PageRequest.of(0, 5))
        val result = post.content[0]
        assertAll({
            assertThat(result.id).isEqualTo(1L)
            assertThat(result.title).isEqualTo("title")
            assertThat(result.content).isEqualTo("content")
            assertThat(result.viewCount).isZero
            assertThat(result.createdDate).isNotNull()
        })
    }

    @Test
    @DisplayName("게시글 찾지 못한경우 예외")
    fun `Should throwException When findById`() {
        assertThatRuntimeException()
            .isThrownBy { postService.updatePost(1L, PostUpdateRequest("title", "content")) }
            .withMessage("게시글을 찾을 수 없습니다.")
    }

    @Test
    @DisplayName("게시글 정상 업데이트")
    fun `Should updateSuccess When updatePost`() {
        val save = postRepository.save(Post("title", "content"))

        postService.updatePost(save.id!!, PostUpdateRequest("제목", "내용"))
        postRepository.flush()
        val updatedPost = postRepository.findById(save.id!!).get()
        assertThat(updatedPost.title).isEqualTo("제목")
        assertThat(updatedPost.content).isEqualTo("내용")
    }
}


