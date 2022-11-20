package com.kedom.productService.entity;

import java.io.Serializable;
import lombok.Data;


@Data
/**
 * spu属性值(PmsProductAttrValue)实体类
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
public class PmsProductAttrValue implements Serializable {
    private static final long serialVersionUID = -34439880648777205L;
    /**
     * id
     */
    private Long id;
    /**
     * 商品id
     */
    private Long spuId;
    /**
     * 属性id
     */
    private Long attrId;
    /**
     * 属性名
     */
    private String attrName;
    /**
     * 属性值
     */
    private String attrValue;
    /**
     * 顺序
     */
    private Integer attrSort;
    /**
     * 快速展示【是否展示在介绍上；0-否 1-是】
     */
    private Integer quickShow;


}

