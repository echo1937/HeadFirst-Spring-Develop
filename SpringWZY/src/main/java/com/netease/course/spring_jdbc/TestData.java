package com.netease.course.spring_jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Eric on 3/14/16.
 */
public class TestData {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("less04-jdbc-context.xml");
        JdbcTemplateDao dao = context.getBean("jdbcTemplateDao", JdbcTemplateDao.class);

//        dao.createTable();
//        dao.insertData();
        System.out.println(dao.count());
        List<User> userList = dao.getUserList();
        for (User user : userList) {
            System.out.println(user.getId() + ": " + user.getFirstName() + " " + user.getLastName());
        }
        ((ConfigurableApplicationContext) context).close();
    }
}
