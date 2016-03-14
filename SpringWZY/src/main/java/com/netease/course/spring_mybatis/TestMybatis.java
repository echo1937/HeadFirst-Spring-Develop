package com.netease.course.spring_mybatis;

import com.netease.course.spring_jdbc.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Eric on 3/14/16.
 */
public class TestMybatis {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("less04-jdbc-context.xml");
        MybatisUserDao dao = context.getBean("mybatisUserDao", MybatisUserDao.class);
        List<User> userList = dao.getUserList();

        for (User user : userList) {
            System.out.println(user.getFirstName() + ", " + user.getLastName());
        }

        User lilei = dao.getUser("Lei");
        System.out.println(lilei.getFirstName() + ", " + lilei.getLastName());


        ((ConfigurableApplicationContext) context).close();
    }
}
