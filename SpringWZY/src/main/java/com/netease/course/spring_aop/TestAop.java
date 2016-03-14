package com.netease.course.spring_aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("less03-aop-context.xml");
        Caculator caculator = context.getBean("caculator", Caculator.class);

        System.out.println("1+1:\n" + caculator.add(1, 1) + "\n");
        System.out.println("5-2:\n" + caculator.sub(5, 2) + "\n");
        System.out.println("what is caculator.getClass():\n" + caculator.getClass());

        ((ConfigurableApplicationContext) context).close();
    }
}
