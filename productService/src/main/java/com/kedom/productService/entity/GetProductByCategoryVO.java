package com.kedom.productService.entity;

import com.kedom.productService.entity.vo.Attr;
import lombok.Data;

import java.util.List;

@Data
public class GetProductByCategoryVO {
    private Long catId;
    private Integer offset;
    private Integer limit;
    private Long priceLow;
    private Long priceHigh;
    private List<Attr> attrs;
}
