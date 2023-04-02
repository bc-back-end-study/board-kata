package com.kata.board.post.service

import com.kata.board.user.domain.User
import com.kata.board.post.domain.Post
import com.kata.board.post.repository.PostRepository
import com.kata.board.post.service.request.PostRequest
import com.kata.board.user.repository.UserRepository
import com.kata.board.util.BoardBootTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest

@SpringBootTest
class PostServiceTest(
    @Autowired private val postRepository: PostRepository,
    @Autowired private val postService: PostService,
    @Autowired private val userRepository: UserRepository
): BoardBootTest() {

    @AfterEach
    fun clean() {
        cleanup!!.execute()
    }

    @Test
    @DisplayName("게시글 페이징 조회 시 정상 반환")
    fun `Should findAllPagenatedPost When getPostAll`() {
        //given
        postRepository.save(Post("제목", "내용", User("유저명", "123", "별명", "test@gmail.com")))

        //when
        val findAllPagenatedPost = postService.findAllPagenatedPost(PageRequest.of(0, 5))

        //then
        val result = findAllPagenatedPost.content[0]
        assertAll({
            assertThat(result.id).isEqualTo(1L)
            assertThat(result.title).isEqualTo("제목")
            assertThat(result.content).isEqualTo("내용")
            assertThat(result.username).isEqualTo("유저명")
            assertThat(result.viewCount).isZero
            assertThat(result.createdDate).isNotNull()
        })
    }

    @Test
    @DisplayName("게시글 등록하기")
    fun `Should register post When user post registration request`() {
        //given
        userRepository.save(User("테스트", "password", "별명", "test@email.com"))

        //when
        postService.registerPost(PostRequest("title", "content", 1L))

        //then
        val post = postService.findAllPagenatedPost(PageRequest.of(0, 5))
        val result = post.content[0]
        assertAll({
            assertThat(result.id).isEqualTo(1L)
            assertThat(result.title).isEqualTo("title")
            assertThat(result.content).isEqualTo("content")
            assertThat(result.username).isEqualTo("테스트")
            assertThat(result.viewCount).isZero
            assertThat(result.createdDate).isNotNull()
        })
    }
}


