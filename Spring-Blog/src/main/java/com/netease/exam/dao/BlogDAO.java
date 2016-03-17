package com.netease.exam.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;


@Repository
public class BlogDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insertBlog(String title, String content) {
        this.jdbcTemplate.update("INSERT INTO Blog(blogTitle,blogContent) VALUES (?,?)", title, content);
    }

}
