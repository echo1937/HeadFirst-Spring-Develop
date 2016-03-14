package com.netease.course.spring_trx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Eric on 3/14/16.
 */
public class TestRxData {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("less04-jdbc-context.xml");

        AccountDao dao = context.getBean("accountDao", AccountDao.class);
        dao.resetMoney();
        try {
            dao.transferMoney("li", "han", 521);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        List<Account> accountList = dao.accountList();

        for (Account account : accountList) {
            System.out.println(account.getUser() + ": " + account.getBalance());
        }

        ((ConfigurableApplicationContext) context).close();

    }
}
