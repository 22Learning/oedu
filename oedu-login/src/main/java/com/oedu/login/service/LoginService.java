package com.oedu.login.service;

import com.oedu.login.dto.ResponseEntity;
import com.oedu.login.dto.User;
import com.oedu.login.dao.UserMapper;
import com.oedu.login.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
@PropertySource(value = "classpath:/login.properties")
public class LoginService {
    @Autowired
    UserMapper userMapper;

    @Resource
    RedisTemplate<String,Integer> redisTemplate;
    @Value("${login.times:4}")
    private int loginTimes;

    public ResponseEntity<String> login(String phone,String passwd){
        String cacheKey = "login_failed_" + phone;
        //登录次数限制
        Integer loginFailedTimes = redisTemplate.opsForValue().get(cacheKey);
        if(null==loginFailedTimes){
            loginFailedTimes=0;
        }
        if(loginFailedTimes >= loginTimes){
            return ResponseEntity.error("登录次数达到限制，请5分钟后再试");
        }
        passwd = MD5Util.getMd5(passwd);
        User user = userMapper.getOneUser(phone, passwd);

        if(null == user){
            redisTemplate.opsForValue().set(cacheKey,loginFailedTimes+1,5, TimeUnit.MINUTES);
            return ResponseEntity.error("账号或密码错误");
        }
        if(user.getIsEnable() == 0) {
            return ResponseEntity.error("账号已冻结");
        }
        return ResponseEntity.success("登陆成功");
    }
}
