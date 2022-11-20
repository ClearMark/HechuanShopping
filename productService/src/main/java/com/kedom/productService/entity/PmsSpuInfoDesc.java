package com.kedom.productService.entity;

import java.io.Serializable;
import lombok.Data;


@Data
/**
 * spu信息介绍(PmsSpuInfoDesc)实体类
 *
 * @author makejava
 * @since 2022-11-17 14:25:39
 */
public class PmsSpuInfoDesc implements Serializable {
    private static final long serialVersionUID = -46629044916474000L;
    /**
     * 商品id
     */
    private Long spuId;
    /**
     * 商品介绍
     */
    private String decript;


}

