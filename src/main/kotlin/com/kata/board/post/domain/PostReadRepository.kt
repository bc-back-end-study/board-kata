package com.kata.board.post.domain

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface PostReadRepository {

    /**
     * 페이징 처리 된 모든 게시글을 찾습니다.
     * @param pageable 페이징처리(정렬, 개수)
     */
    fun findAllPagenatedPost(pageable: Pageable): Page<Post>

    fun findById(id: Long): Post
}
