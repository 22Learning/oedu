package com.oedu.login.service;

import com.oedu.login.entities.ResponseEntity;
import com.oedu.login.entities.User;
import com.oedu.login.mapper.UserMapper;
import com.oedu.login.utils.MD5Util;
import com.oedu.login.utils.StringUtils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UserMapper userMapper;

    public ResponseEntity<String> login(String phone,String passwd){
        if(StringUtils.isEmptyOrNull(passwd))
            return ResponseEntity.error("账号或密码错误");

        String encode = MD5Encoder.encode(passwd.getBytes());
        passwd = MD5Util.getMd5(passwd);

        User user = userMapper.getOneUser(phone, passwd);

        System.out.println(user);
        if(null == user){
            return ResponseEntity.error("账号或密码错误");
        }
        if(user.getIsEnable() == 0)
            return ResponseEntity.error("账号已冻结");

        return ResponseEntity.success("登陆成功");
    }
}
