package com.kata.board.post.domain

import java.time.LocalDate
import java.time.LocalDateTime

class DateUtils {

    companion object {
        fun convertToLocalDate(dateTime: LocalDateTime?): LocalDate?{
            return dateTime?.toLocalDate()
        }
    }
}
