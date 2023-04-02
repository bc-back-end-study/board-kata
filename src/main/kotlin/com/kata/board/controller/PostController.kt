package com.kata.board.controller

import com.kata.board.dto.PostDto
import com.kata.board.service.PostService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("board/posts/v1")
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

    @PostMapping
    fun savePost(postDto: PostDto): ResponseEntity<Any> {
        return ResponseEntity.ok().body(postService.savePost(postDto))
    }
}