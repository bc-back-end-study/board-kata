package com.kata.board.service

import com.kata.board.dto.PostDto

interface PostService {
    fun getPost(id: Long): PostDto

    fun getAllPost(): List<PostDto>

    fun savePost(postDto: PostDto): Long?
}