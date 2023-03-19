package com.kata.board.repository.post

import com.kata.board.entity.Post

interface PostRepository {
    fun getPost(id: Long): Post

    fun getAllPost(): List<Post>
}