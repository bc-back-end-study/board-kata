package com.kata.board.service

import com.kata.board.dto.PostDto
import com.kata.board.entity.Post

interface PostService {
    fun getPost(id: Long): PostDto

    fun getAllPost(): List<PostDto>

    fun savePost(postDto: PostDto): Post

    fun deletePost(id: Long)

    fun updatePost(postDto: PostDto): Post
}