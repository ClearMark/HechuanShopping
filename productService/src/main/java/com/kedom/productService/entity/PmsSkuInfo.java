package com.kedom.productService.entity;

import java.io.Serializable;
import lombok.Data;


@Data
/**
 * sku信息(PmsSkuInfo)实体类
 *
 * @author makejava
 * @since 2022-11-19 13:20:35
 */
public class PmsSkuInfo implements Serializable {
    private static final long serialVersionUID = -98921094499767327L;
    /**
     * skuId
     */
    private Long skuId;
    /**
     * spuId
     */
    private Long spuId;
    /**
     * sku名称
     */
    private String skuName;
    /**
     * sku介绍描述
     */
    private String skuDesc;
    /**
     * 所属分类id
     */
    private Long catalogId;
    /**
     * 品牌id
     */
    private Long brandId;
    /**
     * 默认图片
     */
    private String skuDefaultImg;
    /**
     * 标题
     */
    private String skuTitle;
    /**
     * 副标题
     */
    private String skuSubtitle;
    /**
     * 价格
     */
    private Double price;
    /**
     * 销量
     */
    private Long saleCount;
    /**
     * 商家ID
     */
    private Long skuBelong;


}

