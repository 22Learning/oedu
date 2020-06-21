package com.oedu.common.result;


import lombok.Getter;

@Getter
public enum ResultEnum {
    SUCCESS("000000", "success"),

    ;

    private String status;
    private String msg;

    ResultEnum(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
