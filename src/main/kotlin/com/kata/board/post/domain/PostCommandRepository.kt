package com.kata.board.post.domain

interface PostCommandRepository {
    fun save(post: Post): Post
}
