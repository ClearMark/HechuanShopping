package com.kedom.productService.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
/**
 * (PmsRecommendProduct)实体类
 *
 * @author makejava
 * @since 2023-04-10 14:07:40
 */
public class PmsRecommendProduct implements Serializable {
    private static final long serialVersionUID = 898129682372716529L;

    private Integer id;

    private Integer userId;

    private Integer skuId;

    private Integer catId;

    private LocalDateTime crtateTime;


}

