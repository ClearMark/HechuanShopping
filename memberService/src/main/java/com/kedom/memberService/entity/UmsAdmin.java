package com.kedom.memberService.entity;

import lombok.Data;

import java.io.Serializable;


@Data
/**
 * (UmsAdmin)实体类
 *
 * @author makejava
 * @since 2023-04-16 21:03:33
 */
public class UmsAdmin implements Serializable {
    private static final long serialVersionUID = 750641572796506081L;

    private Integer id;

    private String username;

    private String password;

    private String parentId;


}

