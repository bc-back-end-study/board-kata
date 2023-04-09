package com.kata.board.post.controller

import com.kata.board.post.service.PostService
import com.kata.board.post.service.request.PostUpdateRequest
import com.kata.board.post.service.response.PagingResponse
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
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

    @PutMapping("/{id}")
    fun updatePost(@PathVariable id: Long, @Valid @RequestBody request: PostUpdateRequest): ResponseEntity<Void> {
        postService.updatePost(id, request)
        return ResponseEntity.ok().build()
    }

}
