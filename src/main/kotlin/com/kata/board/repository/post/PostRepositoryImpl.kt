package com.kata.board.repository.post

import com.kata.board.dto.PostDto
import com.kata.board.entity.Post
import com.kata.board.repository.BoardJpaRepository
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Repository

@Repository
class PostRepositoryImpl (
    private val boardJpaRepository: BoardJpaRepository,
): PostRepository {
    override fun getPost(id: Long): Post {
        return boardJpaRepository.findById(id).get()
    }

    override fun getAllPost(): List<Post> {
        return boardJpaRepository.findAll()
    }

    override fun savePost(postDto: PostDto): Post {
        return boardJpaRepository.save(postDto.convertPostDtoFromPost())
    }

    override fun deletePost(id: Long) {
        boardJpaRepository.deleteById(id)
    }
}