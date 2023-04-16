package com.kata.board.post.repository

import com.kata.board.post.domain.Post
import com.kata.board.post.domain.PostCommandRepository
import org.springframework.stereotype.Repository

@Repository
class PostCommandRepositoryImpl(
    private val postRepository: PostRepository
): PostCommandRepository {

    override fun save(post: Post): Post {
        return postRepository.save(post)
    }

    override fun delete(id: Long) {
        postRepository.deleteById(id)
    }

}
