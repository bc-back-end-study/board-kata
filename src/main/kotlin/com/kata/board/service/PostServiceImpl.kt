package com.kata.board.service

import com.kata.board.dto.PostDto
import com.kata.board.entity.Post
import com.kata.board.repository.post.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PostServiceImpl(
    private val postRepository: PostRepository
) : PostService {
    override fun getPost(id: Long): PostDto {
        return postRepository.getPost(id).convertPostFromPostDto()
    }

    override fun getAllPost(): List<PostDto> {
        return postRepository.getAllPost().map { it.convertPostFromPostDto() }
    }

    override fun savePost(postDto: PostDto): Post {
        return postRepository.savePost(postDto)
    }

    override fun deletePost(id: Long) {
        postRepository.deletePost(id)
    }

    override fun updatePost(postDto: PostDto): Post {
        return postRepository.savePost(postDto)
    }
}