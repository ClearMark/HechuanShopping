package com.kedom.productService.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;


@Data
/**
 * spu信息(PmsSpuInfo)实体类
 *
 * @author makejava
 * @since 2022-11-19 01:12:25
 */
public class PmsSpuInfo implements Serializable {
    private static final long serialVersionUID = 985307542077288371L;
    /**
     * 商品id
     */
    private Long id;
    /**
     * 商品名称
     */
    private String spuName;
    /**
     * 商品描述
     */
    private String spuDescription;
    /**
     * 所属分类id
     */
    private Long catalogId;
    /**
     * 品牌id
     */
    private Long brandId;
    
    private Double weight;
    /**
     * 上架状态[0 - 下架，1 - 上架]
     */
    private Integer publishStatus;
    
    private LocalDateTime createTime;
    
    private LocalDateTime updateTime;
    /**
     * 商家ID
     */
    private Long spuBelong;


}

