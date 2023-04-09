package com.kata.board.post.util

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import javax.sql.DataSource

@Component
class DataBaseCleanUp(
    @Autowired private val dataSource: DataSource,
    @Autowired private val jdbcTemplate: JdbcTemplate
){

    @Transactional
    fun execute() {
        jdbcTemplate.execute("SET REFERENTIAL_INTEGRITY FALSE")
        jdbcTemplate.execute("TRUNCATE TABLE post")
        jdbcTemplate.execute("SET REFERENTIAL_INTEGRITY TRUE")
    }
}
