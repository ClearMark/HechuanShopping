/**
  * Copyright 2021 bejson.com 
  */
package com.kedom.productService.entity.vo;

import lombok.Data;

/**
 * Auto-generated: 2021-01-24 18:17:40
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
public class BaseAttrs {

    private Long attrId;
    private String attrValues;
    private int showDesc;

    public BaseAttrs(Long attrId, String attrValues) {
        this.attrId = attrId;
        this.attrValues = attrValues;
    }
}