package com.kedom.productService.entity;

import java.io.Serializable;
import lombok.Data;


@Data
/**
 * 属性分组(PmsAttrGroup)实体类
 *
 * @author makejava
 * @since 2022-11-03 18:34:54
 */
public class PmsAttrGroup implements Serializable {
    private static final long serialVersionUID = -55341634309907265L;
    /**
     * 分组id
     */
    private Long attrGroupId;
    /**
     * 组名
     */
    private String attrGroupName;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 描述
     */
    private String descript;
    /**
     * 组图标
     */
    private String icon;
    /**
     * 所属分类id
     */
    private Long catelogId;


}

