package com.kata.board.repository.post

import com.kata.board.dto.PostDto
import com.kata.board.entity.Post

interface PostRepository {
    fun getPost(id: Long): Post

    fun getAllPost(): List<Post>

    fun savePost(postDto: PostDto): Post

    fun deletePost(id: Long)
}