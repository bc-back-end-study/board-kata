package com.kata.board.user.repository

import com.kata.board.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>
