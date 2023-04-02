package com.kata.board.post.controller

import com.kata.board.post.service.PostService
import com.kata.board.post.service.response.PagingResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts/v1")
class PostController(
    private val postService: PostService
) {

    @GetMapping
    fun findAllPagenatedPost(@PageableDefault(size = 10, page = 0) pageable: Pageable): ResponseEntity<Page<PagingResponse>> {
        val findAllPagenatedPost = postService.findAllPagenatedPost(pageable)
        return ResponseEntity.ok(findAllPagenatedPost)
    }

}
