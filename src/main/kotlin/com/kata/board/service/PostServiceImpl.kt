package com.kata.board.service

import com.kata.board.dto.PostDto
import com.kata.board.repository.post.PostRepository
import org.springframework.beans.factory.annotation.Autowired

class PostServiceImpl @Autowired constructor(
    private val postRepository: PostRepository
) : PostService {
    override fun getPost(id: Long): PostDto {
        return postRepository.getPost(id).mappingPostFromPostDto()
    }

    override fun getAllPost(): List<PostDto> {
        return postRepository.getAllPost().map { it.mappingPostFromPostDto() }
    }
}