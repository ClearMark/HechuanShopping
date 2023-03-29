package com.kedom.productService.entity.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryAttrVO {
    public Long attrId;
    public String attrName;
    public String catelogId;
    public String categoryName;

    public List<String> attrValueList=new ArrayList<>();
}
