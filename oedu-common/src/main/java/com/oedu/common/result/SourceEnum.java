package com.oedu.common.result;

import java.util.Arrays;

public enum SourceEnum {
    OEDU_SC("SC", "配置服务"),
    OEDU_LOGIN("login", "用户服务"),
    OEDU_EXAM("exam", "考试服务"),
    ;
    private String code ;
    private String name;
    SourceEnum(String code, String name){
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String parse(String code) {
        return Arrays.stream(SourceEnum.values())
                .filter(sourceEnum -> sourceEnum.getCode().equals(code))
                .map(SourceEnum::getName)
                .max(String::compareTo)
                .orElse("");
    }
}
