package com.kedom.memberService.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
/**
 * (UmsCar)实体类
 *
 * @author makejava
 * @since 2023-04-06 14:21:32
 */
public class UmsCar implements Serializable {
    private static final long serialVersionUID = 950490975692248339L;

    private Integer id;

    private Integer skuId;

    private Integer userId;

    private Integer count;

    private BigDecimal price;

    private String name;

    private String img;


}

