package com.oedu.login.dao;

import com.oedu.login.dto.User;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ly-oyq
 * @since 2020-06-21
 */
public interface UserMapper{

//    @Select("select * from user where phone = #{phone} and password = #{passwd}")
    //新田君，老夫不用注解了
    User getOneUser(String phone,String passwd);

    List<User> selectUserbyId(List<String> userIds);
}
