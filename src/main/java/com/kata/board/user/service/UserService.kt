package com.kata.board.user.service

import com.kata.board.entity.User
import com.kata.board.user.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.RuntimeException

@Service
@Transactional(readOnly = true)
class UserService(
    private val userRepository: UserRepository
) {

    fun findUser(userId: Long): User {
        return userRepository.findById(userId)
            .orElseThrow { RuntimeException("유저를 찾을 수 없습니다.") }
    }
}
