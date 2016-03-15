package com.netease.wzy.data.dataMybatis;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;


public class MybatisDao {

    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);

    }


    public void transferMoney(Long srcUserId, Long targetUserId, double count) {


    }

    private static void throwE() {
        throw new RuntimeException("abort transfer");
    }


}
