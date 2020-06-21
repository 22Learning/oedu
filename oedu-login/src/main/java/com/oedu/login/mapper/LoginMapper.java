package com.oedu.login.mapper;

import com.oedu.login.entities.User;
import org.apache.ibatis.annotations.Select;

public interface LoginMapper {

    @Select("select * from ")
    public User getUser();

}
