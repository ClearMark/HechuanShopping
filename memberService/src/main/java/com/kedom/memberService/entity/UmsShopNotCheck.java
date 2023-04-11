package com.kedom.memberService.entity;

import lombok.Data;

import java.io.Serializable;


@Data
/**
 * (UmsShopNotCheck)实体类
 *
 * @author makejava
 * @since 2023-04-07 18:04:59
 */
public class UmsShopNotCheck implements Serializable {
    private static final long serialVersionUID = 686823999175571029L;

    private Integer id;

    private Integer shopName;

    private String idCardFront;

    private String idCardBack;

    private String permitFront;

    private String permitBack;

    private Integer userId;

    private Integer status;


}

