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
import java.util.Random

@SpringBootTest
class PostSaveTest (
    @Autowired private val postService: PostService,
) {
    @Test
    @DisplayName("게시글을 등록 했을 때 id값이 0보다 커야한다.")
    fun `Save Post Item`() {

        //given
        val poseDto = PostDto(
            title = "Test Title",
            content = "Test Content",
            )

        //when
        val result = postService.savePost(poseDto)

        //then
        assertThat(result.id).isGreaterThan(0L)
    }

    @Test
    @DisplayName("게시글 조회 했을 경우 검색한 id와 검색한 id 값이 같아야 한다.")
    fun `Get Post Item`() {
        //given
        val beforePosts = postService.getAllPost()

        val result = postService.getPost(beforePosts[0].id?:return)

        assertThat(result.id).isEqualTo(beforePosts[0].id)
    }

    @Test
    @DisplayName("게시글 삭제 후 게시글 전체 갯수가 작아져야한다.")
    fun `Delete Post Item`() {
        //given
        val beforePosts = postService.getAllPost()

        //when
        postService.deletePost(beforePosts[0].id ?: return)

        //then
        val afterPosts = postService.getAllPost()

        assertThat(beforePosts.size).isGreaterThan(afterPosts.size)
    }

    @Test
    @DisplayName("업데이트 이후 게시글 갯수는 같고 내용은 같지 않아야 한다.")
    fun `Update Post Item`() {
        //given
        val beforePosts = postService.getAllPost()

        val poseDto = PostDto(
            id = beforePosts[0].id,
            title = "Test Title",
            content = getRandomString(),
        )

        //when
        postService.updatePost(poseDto)

        //then
        val afterPosts = postService.getAllPost()
        assertThat(beforePosts.size).isEqualTo(afterPosts.size)
        assertThat(beforePosts[0].content).isNotEqualTo(afterPosts[0].content)

    }


    fun getRandomString() : String {
        val length = Random().nextInt(100 - 0) + 100
        val charset = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        return (1..length)
            .map { charset.random() }
            .joinToString("")
    }
}