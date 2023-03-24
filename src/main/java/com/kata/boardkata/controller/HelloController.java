package com.kata.boardkata.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/test/hi")
    public String hello() {
        return "hi";
    }
}
