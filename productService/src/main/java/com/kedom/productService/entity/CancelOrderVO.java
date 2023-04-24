package com.kedom.productService.entity;

import lombok.Data;

@Data
public class CancelOrderVO {

    private String orderSn;

    private String status;

    private String cancelString;
}
