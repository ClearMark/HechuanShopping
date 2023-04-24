package com.kedom.productService.entity;

import lombok.Data;

@Data
public class ShopSearchVO {
    private Integer pageNum;
    private Integer pageSize;
    private String shopName;
}
