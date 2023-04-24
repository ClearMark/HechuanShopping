/**
  * Copyright 2021 bejson.com 
  */
package com.kedom.productService.entity.vo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Auto-generated: 2021-01-24 18:17:40
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
public class Sku {

    private List<Attr> attr;
    private Long skuId;
    private String skuName;
    private BigDecimal price;
    private String skuDesc;
    private String skuDefaultImg;
    private Long catalogId;
    private Long userId;
    private Long stock;
    private Long saleCount;
    private String imgList;
}
