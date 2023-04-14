package com.kata.board.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/test/hi")
    fun hi(): String {
        return "hi"
    }
}
