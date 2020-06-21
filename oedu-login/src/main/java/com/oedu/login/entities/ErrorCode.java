package com.oedu.login.entities;

import org.springframework.context.annotation.PropertySource;

@PropertySource("error_msg_")
public class ErrorCode {
    private static String getErrorMsg(int errorCode){
        return null;//todo 加载配置文件全部error_msg_开头的并封装到map
    }
}
