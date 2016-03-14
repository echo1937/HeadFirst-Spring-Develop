package com.netease.wzy.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Eric on 3/14/16.
 */
public class TestAopTask {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("task-aop-context.xml");
        Service01 service01 = context.getBean("service01", Service01.class);
        Service02 service02 = context.getBean("service02", Service02.class);

        service01.insert();
        service02.insert();
        try {
            service01.throwErr();
        } catch (Exception e) {
        }

        ((ConfigurableApplicationContext) context).close();
    }
}
