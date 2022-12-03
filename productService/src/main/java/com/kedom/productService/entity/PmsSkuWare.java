package com.kedom.productService.entity;

import lombok.Data;

import java.io.Serializable;


@Data
/**
 * 商品库存(PmsSkuWare)实体类
 *
 * @author makejava
 * @since 2022-12-02 23:55:27
 */
public class PmsSkuWare implements Serializable {
    private static final long serialVersionUID = -84753577293578228L;
    /**
     * id
     */
    private Long id;
    /**
     * sku_id
     */
    private Long skuId;
    /**
     * 库存数
     */
    private Integer stock;
    /**
     * sku_name
     */
    private String skuName;
    /**
     * 锁定库存
     */
    private Integer stockLocked;


}

