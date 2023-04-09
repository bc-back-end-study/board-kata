package com.kata.board.post.controller

import com.kata.board.post.service.PostService
import com.kata.board.post.service.request.PostRequest
import com.kata.board.post.service.response.PagingResponse
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

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

    @PostMapping
    fun registerPost(@Valid @RequestBody request: PostRequest): ResponseEntity<Void> {
        postService.registerPost(request)
        return ResponseEntity.created(URI.create("/posts/v1")).build()
    }

}
