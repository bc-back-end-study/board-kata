package com.kata.board.repository

import com.kata.board.entity.Post
import org.springframework.beans.factory.annotation.Autowired

class PostRepositoryImpl @Autowired constructor(
    private val boardRepository: BoardRepository,
): PostRepository {
    override fun getPost(id: Long): Post {
        return boardRepository.findById(id).get()
    }

    override fun getAllPost(): List<Post> {
        return boardRepository.findAll()
    }


}