package com.kedom.productService.entity;

import java.io.Serializable;
import lombok.Data;


@Data
/**
 * sku图片(PmsSkuImages)实体类
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
public class PmsSkuImages implements Serializable {
    private static final long serialVersionUID = -61207074933668308L;
    /**
     * id
     */
    private Long id;
    /**
     * sku_id
     */
    private Long skuId;
    /**
     * 图片地址
     */
    private String imgUrl;
    /**
     * 排序
     */
    private Integer imgSort;
    /**
     * 默认图[0 - 不是默认图，1 - 是默认图]
     */
    private Integer defaultImg;


}

