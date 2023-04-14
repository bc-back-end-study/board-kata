package com.kata.board.post.repository

import com.kata.board.post.domain.Post
import com.kata.board.post.domain.PostReadRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable

class PostReadRepositoryImplTest {

    private val postReadRepository: PostReadRepository = MockPostReadRepository()

    @Test
    @DisplayName("데이터가 없는 경우 빈값 반환")
    fun Should_emptyList_When_findAllPostNothingResult() {
        val actual = postReadRepository.findAllPagenatedPost(PageRequest.of(0, 5))
        assertThat(actual).isEmpty()
    }

    inner class MockPostReadRepository : PostReadRepository {
        private val map: Map<Long, Post> = HashMap()
        override fun findAllPagenatedPost(pageable: Pageable): Page<Post> {
            return Page.empty()
        }

        override fun findById(id: Long): Post {
            TODO("Not yet implemented")
        }

    }
}

