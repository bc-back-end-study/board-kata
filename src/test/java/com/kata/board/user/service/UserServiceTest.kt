package com.kata.board.user.service

import com.kata.board.entity.User
import com.kata.board.user.repository.UserRepository
import com.kata.board.util.BoardBootTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class UserServiceTest(
    @Autowired private val userService: UserService,
    @Autowired private val userRepository: UserRepository
): BoardBootTest() {

    @Test
    fun test() {
        //given
        userRepository.save(User("테스트", "password", "별명", "test@email.com"))

        //when
        val user = userService.findUser(1L)

        //then
        assertThat(user.username).isEqualTo("테스트")
        assertThat(user.password).isEqualTo("password")
        assertThat(user.nickname).isEqualTo("별명")
        assertThat(user.email).isEqualTo("test@email.com")
    }

}
