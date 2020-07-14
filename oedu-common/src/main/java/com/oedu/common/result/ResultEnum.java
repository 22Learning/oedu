package com.oedu.common.result;


import lombok.Getter;

@Getter
public enum ResultEnum {
    SUCCESS("000000", "success"),
    ERROR("111112", "error"),
    USER_ERROR("111111", "userError"),
    REQUEST_PARAM_ERROR("111115","requestParamError")

    ;

    private String status;
    private String msg;

    ResultEnum(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
