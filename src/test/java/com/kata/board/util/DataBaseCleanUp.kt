package com.kata.board.util

import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.sql.DatabaseMetaData
import java.sql.ResultSet
import javax.sql.DataSource


@Profile("test")
@Service
class DatabaseCleanup : InitializingBean {
    @Autowired
    private val dataSource: DataSource? = null

    @Autowired
    private val jdbcTemplate: JdbcTemplate? = null
    private var tableNames: MutableList<String>? = null
    override fun afterPropertiesSet() {
        tableNames = ArrayList()
        try {
            val metaData: DatabaseMetaData = dataSource!!.connection.metaData
            val tables: ResultSet = metaData.getTables(null, null, null, arrayOf("TABLE"))
            while (tables.next()) {
                val tableName = tables.getString("TABLE_NAME")
                (tableNames as ArrayList<String>).add(tableName)
            }
        } catch (e: Exception) {
            throw RuntimeException()
        }
    }

    @Transactional
    fun execute() {
        jdbcTemplate!!.execute("SET REFERENTIAL_INTEGRITY FALSE")
        for (tableName in tableNames!!) {
            jdbcTemplate.execute("TRUNCATE TABLE $tableName")
        }
        jdbcTemplate.execute("SET REFERENTIAL_INTEGRITY TRUE")
    }
}
