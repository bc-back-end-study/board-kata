package com.kata.board.repository.post

import com.kata.board.dto.PostDto
import com.kata.board.entity.Post
import com.kata.board.repository.BoardJpaRepository
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Repository

@Repository
class PostRepositoryImpl (
    private val boardJpaRepository: BoardJpaRepository,
    private val modelMapper: ModelMapper
): PostRepository {
    override fun getPost(id: Long): Post {
        return boardJpaRepository.findById(id).get()
    }

    override fun getAllPost(): List<Post> {
        return boardJpaRepository.findAll()
    }

    override fun savePost(postDto: PostDto): Long? {
        return boardJpaRepository.save(modelMapper.map(postDto,Post::class.java)).id
    }


}