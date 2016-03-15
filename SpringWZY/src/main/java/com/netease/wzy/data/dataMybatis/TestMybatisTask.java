package com.netease.wzy.data.dataMybatis;

import com.netease.wzy.data.dataMybatis.MybatisAnnotation;
import com.netease.wzy.data.dataMybatis.MybatisDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestMybatisTask {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("task-data-context.xml");
        MybatisAnnotation dao = context.getBean("mybatisAnnotation", MybatisAnnotation.class);
        System.out.println(dao.selectAccount(1L).getUserId() + ": " + dao.selectAccount(1L).getBalance());
        System.out.println(dao.selectAccount(2L).getUserId() + ": " + dao.selectAccount(2L).getBalance());

        new MybatisDao().transferMoney(1L, 2L, 100);


        System.out.println(dao.selectAccount(1L).getUserId() + ": " + dao.selectAccount(1L).getBalance());
        System.out.println(dao.selectAccount(2L).getUserId() + ": " + dao.selectAccount(2L).getBalance());
    }


}
