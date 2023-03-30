package com.kata.board.entity

import com.kata.board.dto.PostDto
import jakarta.persistence.*
import org.hibernate.annotations.Comment
import java.lang.IllegalArgumentException
import java.time.format.DateTimeFormatter

@Entity
class Post constructor(

    @Comment("제목")
    var title: String,

    @Column(columnDefinition = "TEXT")
    @Comment("내용")
    private var content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private val user: User

) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null

    @Comment("조회수")
    private var view: Int = 0

    fun mappingPostFromPostDto(): PostDto {
        return PostDto(
            id = this.id ?: throw IllegalArgumentException("Id Null Error"),
            title = this.title,
            userName = this.user.userName,
            createdDate = this.createdDate?: throw IllegalArgumentException("Created Time Null Error"),
            content = this.content,
            view = this.view,
        )
    }

}