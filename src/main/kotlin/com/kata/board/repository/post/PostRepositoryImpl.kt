package com.kata.board.repository.post

import com.kata.board.entity.Post
import com.kata.board.repository.BoardJpaRepository
import org.springframework.beans.factory.annotation.Autowired

class PostRepositoryImpl (
    private val boardJpaRepository: BoardJpaRepository,
): PostRepository {
    override fun getPost(id: Long): Post {
        return boardJpaRepository.findById(id).get()
    }

    override fun getAllPost(): List<Post> {
        return boardJpaRepository.findAll()
    }


}