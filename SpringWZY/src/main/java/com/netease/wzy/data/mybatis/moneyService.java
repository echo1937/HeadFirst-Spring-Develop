package com.netease.wzy.data.mybatis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component(value = "moneyService")
public class MoneyService {

    @Autowired
    private MoneyDao moneyDao;

    public void setMoneyDao(MoneyDao moneyDao) {
        this.moneyDao = moneyDao;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void transferMoney(Long srcUserId, Long targetUserId, double count) {
        moneyDao.updateAccount(srcUserId, -count);
        //throwE();
        moneyDao.updateAccount(targetUserId, count);
    }

    private static void throwE() {
        throw new RuntimeException("abort transfer");
    }


}
