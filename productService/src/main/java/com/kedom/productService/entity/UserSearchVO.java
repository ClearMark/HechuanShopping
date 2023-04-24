package com.kedom.productService.entity;

import lombok.Data;

@Data
public class UserSearchVO {
    private Integer pageNum;
    private Integer pageSize;
    private String username;
    private String email;
}
