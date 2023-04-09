package com.kata.board.util

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
abstract class BoardBootTest {
    @Autowired val cleanup: DatabaseCleanup? = null
}
