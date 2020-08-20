package com.oedu.sc.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;

@ControllerAdvice
@Slf4j
public class ResponseBodyLogAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        Method method = returnType.getMethod();
        ObjectMapper mapper = new ObjectMapper();
        try {
            log.info("{}.{}:result{}",method.getDeclaringClass().getSimpleName(),method.getName(),mapper.writeValueAsString(body));
        } catch (JsonProcessingException e) {
            log.error("{}.{}响应体解析异常:{}",method.getDeclaringClass().getSimpleName(),method.getName(),e);
        }
        return body;
    }
}
