package com.netease.exam.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;


@Repository
public class UserDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String selectUser(String userName) {
        String pw = null;
        try {
            pw = (String) this.jdbcTemplate.queryForObject("SELECT userPassword FROM User WHERE UserName=?",
                    new Object[]{userName}, String.class);
        } catch (Exception e) {
            return "";
        }
        return pw;
    }

}