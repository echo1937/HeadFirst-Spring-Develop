package com.netease.course.spring_trx;

/**
 * Created by Eric on 3/14/16.
 */
public class Account {
    private String user;
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
