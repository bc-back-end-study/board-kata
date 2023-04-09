package com.kata.boardkata.repository;

import com.kata.boardkata.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String userId);
}
