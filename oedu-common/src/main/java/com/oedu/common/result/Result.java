package com.oedu.common.result;

import lombok.Data;


@Data
public class Result<T> {
    private String status;
    private String msg;
    private long timestamp;
    private T data;


    public Result() {
       this(ResultEnum.SUCCESS);
    }

    public Result(ResultEnum resultEnum) {
        this.status = resultEnum.getStatus();
        this.msg = resultEnum.getMsg();
        this.timestamp = System.currentTimeMillis();
    }

    public Result(T data) {
        this(ResultEnum.SUCCESS);
        this.data = data;
    }


    public static Result success() {
        return new Result(ResultEnum.SUCCESS);

    }
}
