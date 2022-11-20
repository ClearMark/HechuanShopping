package com.kedom.productService.entity;

import java.io.Serializable;
import lombok.Data;


@Data
/**
 * sku销售属性&值(PmsSkuSaleAttrValue)实体类
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
public class PmsSkuSaleAttrValue implements Serializable {
    private static final long serialVersionUID = 467708706467081971L;
    /**
     * id
     */
    private Long id;
    /**
     * sku_id
     */
    private Long skuId;
    /**
     * attr_id
     */
    private Long attrId;
    /**
     * 销售属性名
     */
    private String attrName;
    /**
     * 销售属性值
     */
    private String attrValue;
    /**
     * 顺序
     */
    private Integer attrSort;


}

