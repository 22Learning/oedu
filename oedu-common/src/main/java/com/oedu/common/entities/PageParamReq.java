package com.oedu.common.entities;

import lombok.Data;

@Data
public class PageParamReq<T> {
    private int pageNo;

    private int pageSize;

    private T param;
}
