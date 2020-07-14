package com.oedu.sc.common;

import com.oedu.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result unKnowExceptionHandler(HttpServletRequest req,Exception e) {
        log.error("未处理的异常url:{} error:{}",req.getRequestURL(),e);
        return Result.error();
    }

    /**
     * 捕捉任何参数不传所抛出的异常
     */
    @ResponseBody
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public Result doHttpMessageNotReadableException(HttpServletRequest req, HttpMessageNotReadableException e){
        log.error("接口参数不存在url:{} error:{}",req.getRequestURL(),e);
        return Result.requestParamError();
    }

}
