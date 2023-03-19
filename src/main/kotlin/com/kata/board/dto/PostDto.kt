package com.kata.board.dto

data class PostDto(
    val id: Long,
    val title: String,
    val userName: String,
    val createdDate: String,
    var content: String,
    var view: Int,
)