package com.netease.wzy.data.mybatis;

import com.netease.wzy.data.jdbc.BankAccount;
import org.apache.ibatis.annotations.*;

public interface MoneyDao {
    @Results({
            @Result(property = "userId", column = "id"),
            @Result(property = "balance", column = "balance")
    })
    @Select("select id,balance from account where id=#{id}")
    BankAccount selectAccount(Long id);

    @Results({
            @Result(property = "userId", column = "id"),
            @Result(property = "balance", column = "balance")
    })
    @Update("update account set balance=balance+#{count} where id=#{userId}")
    void updateAccount(@Param(value = "userId") long userId, @Param(value = "count") double count);

}
