package com.netease.wzy.data;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Eric on 3/15/16.
 */
public class TestJdbcTask {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("task-data-context.xml");
        JdbcDao dao = context.getBean("jdbcDao", JdbcDao.class);

        dao.resetMoney();
        try {
            dao.transferMoney(1L, 2L, 211);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        List<BankAccount> accountList = dao.accountList();
        for (BankAccount account : accountList) {
            System.out.println(account.getUserId() + ": " + account.getBalance());
        }

        ((ConfigurableApplicationContext) context).close();
    }
}
