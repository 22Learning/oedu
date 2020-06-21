package com.oedu.common.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseEntity<T> {
    private String msg;
    private int code;
    private T data;

    public ResponseEntity(String msg,int code,T data){
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public static ResponseEntity success(String msg){
        return new ResponseEntity(msg,0,null);
    }

    public static ResponseEntity error(String msg){
        return new ResponseEntity(msg,101,null);
    }

}
