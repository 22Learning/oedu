package com.oedu.common.tools;

import com.oedu.common.entities.LogicException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class UserUtil {
    private static String userId = "userId";

    //获取登录用户，不存在则设置为admin
    public static String getUserId() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String userId = request.getHeader("userId");
        if (StringUtils.isEmpty(userId)) {
            return "admin";
        } else {
            return userId;
        }
    }

    //获取登录用户，不存在就报错
    public static String getUserIdNecessary() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String userId = request.getHeader("userId");
        if (StringUtils.isEmpty(userId)) {
            throw new LogicException("无法获取登录用户");
        } else {
            return userId;
        }
    }
}
