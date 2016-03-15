package com.netease.course.spring_mybatis;

import com.netease.course.spring_jdbc.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Eric on 3/14/16.
 */
public interface MybatisUserDao {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name")
    })
    @Select("select * from user")
    List<User> getUserList();


    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name")
    })
    @Select("select * from user where first_name=#{fisrtName}")
    User getUser(String firstName);
}
