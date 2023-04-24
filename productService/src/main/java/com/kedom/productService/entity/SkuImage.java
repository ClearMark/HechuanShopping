package com.kedom.productService.entity;

import lombok.Data;

import java.util.List;

@Data
public class SkuImage {
    private Integer id;
    private Integer skuId;
    private String imgUrl;
    private List<String> imgUrls;
}
