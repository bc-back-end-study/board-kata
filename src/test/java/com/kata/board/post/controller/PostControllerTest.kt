package com.kata.board.post.controller

import com.kata.board.post.service.PostService
import com.kata.board.post.service.response.PagingResponse
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.mockito.BDDMockito.doNothing
import org.mockito.BDDMockito.`when`
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import java.time.LocalDate
import java.util.stream.Stream

@WebMvcTest(controllers = [PostController::class])
class PostControllerTest {

    companion object {
        private const val POST_BASE_URL = "/posts/v1"

        @JvmStatic
        fun updatePost(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("""
                        {
                            "title": "",
                            "content": "content"
                        }
                    """, "제목은 비어있을 수 없습니다."),
                Arguments.of("""
                        {
                            "title": "title",
                            "content": ""
                        }
                    """, "내용은 비어있을 수 없습니다.")
            )
        }
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
        val responseList = listOf(PagingResponse(1L, "title", "content", 1, LocalDate.now()))
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
            .andExpect { jsonPath("$.content[0].viewCount") { value(1)} }
    }

    @Test
    fun `Should Throw Exception When Title Is Null`() {
        //given
        val json = """
                {
                    "title": "",
                    "content": "content"
                }
            """

        //when
        registPost(json)

        //then
            .andExpect { status { isBadRequest() } }
            .andExpect { jsonPath("$.status") { value(400)} }
            .andExpect { jsonPath("$.message") { value("제목은 null 일 수 없습니다.")} }
    }

    @Test
    fun `Should Throw Exception When content Is Null`() {
        //given
        val json = """
                {
                    "title": "title",
                    "content": ""
                }
            """

        //when
        registPost(json)

            //then
            .andExpect { status { isBadRequest() } }
            .andExpect { jsonPath("$.status") { value(400)} }
            .andExpect { jsonPath("$.message") { value("내용은 null 일 수 없습니다.")} }
    }

    private fun registPost(json: String) = mockMvc.post(POST_BASE_URL) {
        content = json.trimIndent()
        accept = MediaType.APPLICATION_JSON
        contentType = MediaType.APPLICATION_JSON
        characterEncoding = "utf-8"
    }

    @Test
    fun `Should register post When registration Post`() {
        //given
        doNothing().`when`(postService).registerPost(any())
        val json = """
                {
                    "title": "title",
                    "content": "content"
                }
        """.trimIndent()

        //when
        registPost(json)

        //then
            .andExpect { status { isCreated() } }
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T> any(): T {
        Mockito.any<T>()
        return null as T
    }

    @DisplayName("validation 검증 시 예외 400")
    @ParameterizedTest
    @MethodSource("updatePost")
    fun `Should validaitonException When illegal arguments request`(json: String, errorMessage: String) {
        mockMvc.perform(
            put(POST_BASE_URL + "/1").accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json.trimIndent())
                .characterEncoding(Charsets.UTF_8)
        )
            .andExpect(status().isBadRequest)
            .andExpect(jsonPath("$.status").value(400))
            .andExpect(jsonPath("$.message").value(errorMessage))
    }

}
