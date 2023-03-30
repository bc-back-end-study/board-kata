package com.kata.board.controller

import com.kata.board.service.PostService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("board")
class PostController (
    private val postService: PostService
){
    @GetMapping("/{id}")
    fun getPost(@PathVariable id: Long): ResponseEntity<Any> {
        val post = postService.getPost(id)
        return ResponseEntity.ok().body(post)
    }

    @GetMapping(("/post_all"))
    fun getAllPost(): ResponseEntity<Any> {
        return ResponseEntity.ok().body(postService.getAllPost())
    }
}