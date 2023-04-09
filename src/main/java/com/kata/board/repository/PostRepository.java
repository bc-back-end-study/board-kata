package com.kata.board.repository;

import com.kata.board.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
} // JpaRepository : 기본적인 CRUD가 가능하도록 제공하는 인터페이스
