package com.kata.board.post.repository

import com.kata.board.post.domain.Post
import com.kata.board.post.domain.PostReadRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class PostReadRepositoryImpl(
    private val postRepository: PostRepository
): PostReadRepository {
    override fun findAllPagenatedPost(pageable: Pageable): Page<Post> {
        return postRepository.findAll(pageable)
    }

    override fun findById(id: Long): Post {
        return postRepository.findById(id)
            .orElseThrow { RuntimeException("게시글을 찾을 수 없습니다.") }
    }

}
