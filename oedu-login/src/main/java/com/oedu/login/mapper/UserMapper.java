package com.oedu.login.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oedu.login.entities.User;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ly-oyq
 * @since 2020-06-21
 */
public interface UserMapper extends BaseMapper<User> {

//    @Select("select * from user where phone = #{phone} and password = #{passwd}")
    //新田君，老夫不用注解了
    User getOneUser(String phone,String passwd);
}
