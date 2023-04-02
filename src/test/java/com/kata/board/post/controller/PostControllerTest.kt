package com.kata.board.post.controller

import com.kata.board.post.service.PostService
import com.kata.board.post.service.response.PagingResponse
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.`when`
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import java.time.LocalDate

@WebMvcTest(controllers = [PostController::class])
class PostControllerTest {

    companion object {
        private const val POST_BASE_URL = "/posts/v1"
    }

    @Autowired
    private lateinit var ctx: WebApplicationContext

    @MockBean
    private lateinit var postService: PostService

    private lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(ctx)
            .defaultResponseCharacterEncoding<DefaultMockMvcBuilder>(Charsets.UTF_8)
            .alwaysDo<DefaultMockMvcBuilder>(print())
            .build()
    }

    @Test
    @DisplayName("게시글 전체 조회를 하는 경우 페이징 처리된 리스트를 반환한다.")
    fun `Should Paging Post Response When findAllPost`() {
        //given
        val responseList = listOf(PagingResponse(1L, "title", "content", "username", 1, LocalDate.now()))
        val page = PageRequest.of(0, 5)
        `when`(postService.findAllPagenatedPost(any()))
            .thenReturn(PageImpl(responseList, page, 1))

        //when
        mockMvc.get(POST_BASE_URL) { param("size", "0") }
            .andExpect { status { isOk() } }
            .andExpect { jsonPath("$.content") { isNotEmpty()} }
            .andExpect { jsonPath("$.pageable") { isNotEmpty()} }
            .andExpect { jsonPath("$.content[0].id") { value("1")} }
            .andExpect { jsonPath("$.content[0].title") { value("title")} }
            .andExpect { jsonPath("$.content[0].content") { value("content")} }
            .andExpect { jsonPath("$.content[0].username") { value("username")} }
            .andExpect { jsonPath("$.content[0].viewCount") { value(1)} }
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T> any(): T {
        Mockito.any<T>()
        return null as T
    }
}
