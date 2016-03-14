package com.netease.course.spring_trx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Eric on 3/14/16.
 */
@Repository
public class AccountDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void resetMoney() {
        jdbcTemplate.update("UPDATE account SET balance=1000");
    }

    public List<Account> accountList() {
        return this.jdbcTemplate.query("select * from account", new RowMapper<Account>() {
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                Account account = new Account();
                account.setUser(resultSet.getString("user"));
                account.setBalance(resultSet.getDouble("balance"));
                return account;
            }
        });
    }

    public void transferMoney(String source, String target, double count) {
        this.jdbcTemplate.update("UPDATE account SET balance=balance-? WHERE user=?", count, source);
        throwE();
        this.jdbcTemplate.update("UPDATE account SET balance=balance+? WHERE user=?", count, target);
    }

    private void throwE() {
        throw new RuntimeException("abort");
    }
}
