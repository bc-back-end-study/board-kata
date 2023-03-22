package com.kata.board.post.service

import com.kata.board.post.domain.PostReadRepository
import com.kata.board.post.service.response.PagingResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PostService(
    private val postReadRepository: PostReadRepository
) {
    fun findAllPagenatedPost(page: Pageable): Page<PagingResponse> {
        val pagenatedPost = postReadRepository.findAllPagenatedPost(page)
        return pagenatedPost.map { post ->
            PagingResponse(
                post.id,
                post.title,
                post.content,
                post.user?.username,
                post.view,
                post.convertToLocalDate()
            )
        }
    }
}
