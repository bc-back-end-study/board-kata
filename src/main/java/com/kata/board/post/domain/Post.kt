package com.kata.board.post.domain

import com.kata.board.entity.BaseEntity
import com.kata.board.entity.User
import jakarta.persistence.*
import org.hibernate.annotations.Comment

@Entity
class Post(
    @Comment("제목")
    private var title: String,

    @Comment("내용")
    @Column(columnDefinition = "TEXT")
    private var content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    private var user: User? = null
): BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null

    @Comment("조회 수")
    private var view: Int = 0

}
