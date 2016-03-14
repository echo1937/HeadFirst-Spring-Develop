package com.netease.course.spring_jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * Created by Eric on 3/14/16.
 */
@Repository
public class JdbcTemplateDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }

    public void createTable() {
        jdbcTemplate.execute("CREATE TABLE user(id INTEGER ,first_name VARCHAR(100),last_name VARCHAR(100))");
    }

    public void insertData() {
        this.jdbcTemplate.update("INSERT INTO user values(1,?,?)", "Meimie", "Han");
        this.jdbcTemplate.update("INSERT INTO user values(2,?,?)", "Lei", "Li");
    }

    public int count() {
        return this.jdbcTemplate.queryForObject("select count(*) from user", Integer.class);
    }
}
