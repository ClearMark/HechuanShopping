package com.kedom.productService.entity;

import lombok.Data;

@Data
public class SkuHotVO {
    private Long categoryId;
    private String skuName;
    private Integer offset;
    private Integer limit;
}
