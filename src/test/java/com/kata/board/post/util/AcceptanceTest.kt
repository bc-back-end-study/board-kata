package com.kata.board.post.util

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
abstract class AcceptanceTest(
    @Autowired private val clean: DataBaseCleanUp
)
