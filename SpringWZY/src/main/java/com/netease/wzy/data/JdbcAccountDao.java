package com.netease.wzy.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Eric on 3/15/16.
 */
@Repository
public class JdbcAccountDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void resetMoney() {
        jdbcTemplate.update("UPDATE account SET balance=1000");
    }

    public List<BankAccount> accountList() {
        return this.jdbcTemplate.query("select * from account", new RowMapper<BankAccount>() {
            public BankAccount mapRow(ResultSet resultSet, int i) throws SQLException {
                BankAccount bankAccount = new BankAccount();
                bankAccount.setUserId(resultSet.getInt("id"));
                bankAccount.setBalance(resultSet.getDouble("balance"));
                return bankAccount;
            }
        });
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void transferMoney(Long srcUserId, Long targetUserId, double count) {
        this.jdbcTemplate.update("UPDATE account SET balance=balance-? WHERE id=?", count, srcUserId);
        //throwE();
        this.jdbcTemplate.update("UPDATE account SET balance=balance+? WHERE id=?", count, targetUserId);
    }

    private void throwE() {
        throw new RuntimeException("abort transfer");
    }
}
