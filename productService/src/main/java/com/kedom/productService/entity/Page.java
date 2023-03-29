package com.kedom.productService.entity;

import lombok.Data;

@Data
public class Page {
    Integer pageNum;
    Integer pageBegin;
    Integer pageSize;
    Integer nowMaxID;

    public Page(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pageBegin = (pageNum - 1) * pageSize;
    }
}
