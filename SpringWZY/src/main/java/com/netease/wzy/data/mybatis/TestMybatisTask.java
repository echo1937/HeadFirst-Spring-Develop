package com.netease.wzy.data.mybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestMybatisTask {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("task-mybatis-content.xml");
        MoneyService dao = context.getBean("moneyService", MoneyService.class);

        dao.transferMoney(1L, 2L, 100);

    }


}
