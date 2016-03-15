package com.netease.wzy.data.dataMybatis;

import com.netease.wzy.data.BankAccount;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MybatisAnnotation {
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
    @Update("update account set balance=#{balance} where id=#{userId}")
    void updateAccount(BankAccount bankAccount);

}
