package com.kedom.productService.entity;

import java.io.Serializable;
import lombok.Data;


@Data
/**
 * spu图片(PmsSpuImages)实体类
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
public class PmsSpuImages implements Serializable {
    private static final long serialVersionUID = -39649205411253978L;
    /**
     * id
     */
    private Long id;
    /**
     * spu_id
     */
    private Long spuId;
    /**
     * 图片名
     */
    private String imgName;
    /**
     * 图片地址
     */
    private String imgUrl;
    /**
     * 顺序
     */
    private Integer imgSort;
    /**
     * 是否默认图
     */
    private Integer defaultImg;


}

