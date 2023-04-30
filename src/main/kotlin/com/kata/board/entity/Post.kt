package com.kata.board.entity

import com.kata.board.dto.PostDto
import jakarta.persistence.*
import org.hibernate.annotations.Comment
import java.lang.IllegalArgumentException

@Entity
class Post constructor(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Comment("제목")
    var title: String,

    @Column(columnDefinition = "TEXT")
    @Comment("내용")
    private var content: String,

) : BaseEntity() {

    @Comment("조회수")
    private var view: Int = 0

    fun convertPostFromPostDto(): PostDto {
        return PostDto(
            id = this.id ?: throw IllegalArgumentException("Id Null Error"),
            title = this.title,
            createdDate = this.createdDate?: throw IllegalArgumentException("Created Time Null Error"),
            modifiedDate = this.modifiedDate?: throw IllegalArgumentException("Modified Time Null Error"),
            content = this.content,
            view = this.view,
        )
    }

}