package com.kedom.memberService.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;


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

    private String shopName;

    private String idCardFront;

    private String idCardBack;

    private String permitFront;

    private String permitBack;

    private Integer userId;

    private Integer status;

    private String cause;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;


}

