package com.netease.wzy.aop;

/**
 * Created by Eric on 3/14/16.
 */
public class Service01 {
    public void insert() {
        System.out.println("in Service01.insert");
    }

    public void delete() {
        System.out.println("in Service01.delete");
    }

    public void update() {
        System.out.println("in Service01.update");
    }

    public void query() {
        System.out.println("in Service01.query");
    }

    public void throwErr() {
        System.out.println("in Service01.throwErr");
        int i = 1 / 0;
    }
}
