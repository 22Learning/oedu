package com.oedu.login.service;

import com.oedu.common.tools.ListUtil;
import com.oedu.login.dao.UserMapper;
import com.oedu.login.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class UserService implements UserInterface{

    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, String> getNameByIds(List<String> userIds) {
        if (ListUtil.isEmpty(userIds)) {
            return new HashMap<>();
        }
        List<User> userList = userMapper.selectUserbyId(userIds);
        return userList.stream().collect(Collectors.toMap(User::getPhone, User::getNickName, (k, v) -> v));
    }

}
