package com.oedu.common.entities;

import com.github.pagehelper.Page;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageParamRsp<T> {

    private int pageSum;

    private long totalSum;

    private int pageNo;

    private int pageSize;

    private List<T> param;

    public PageParamRsp() {

    }

    public PageParamRsp(List list) {
        if (list == null) {
            list = new ArrayList();
        }
        if (list instanceof Page) {
            Page page = (Page) list;
            this.pageNo = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.pageSum = page.getPages();
            this.totalSum = page.getTotal();
            this.param = page.getResult();
        }else{
            this.param = list;
        }

    }
}
