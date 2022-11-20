package com.kedom.productService.entity;

import java.io.Serializable;
import lombok.Data;


@Data
/**
 * 品牌分类关联(PmsCategoryBrandRelation)实体类
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
public class PmsCategoryBrandRelation implements Serializable {
    private static final long serialVersionUID = -19939615668743767L;
    
    private Long id;
    /**
     * 品牌id
     */
    private Long brandId;
    /**
     * 分类id
     */
    private Long catelogId;
    
    private String brandName;
    
    private String catelogName;


}

