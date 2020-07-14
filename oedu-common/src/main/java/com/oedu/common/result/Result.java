package com.oedu.common.result;

import com.oedu.common.entities.LogicException;
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

    public static Result requestParamError() {
        return new Result(ResultEnum.REQUEST_PARAM_ERROR);
    }

    public boolean isSuccess() {
        return ResultEnum.SUCCESS.equals(this.status);
    }

    public static Result success() {
        return new Result(ResultEnum.SUCCESS);
    }

    public static Result error() {
        return new Result(ResultEnum.ERROR);
    }


    public static Result userError() {
        return new Result(ResultEnum.USER_ERROR);
    }

    public T getDataThrowException(String source) {
        if (isSuccess()) {
            return this.data;
        }else{
            throw new LogicException(source+"接口调用失败: "+this.msg);
        }
    }
}
