package com.kedom.productService.entity;

import java.io.Serializable;
import lombok.Data;


@Data
/**
 * 属性&属性分组关联(PmsAttrAttrgroupRelation)实体类
 *
 * @author makejava
 * @since 2022-11-17 14:25:16
 */
public class PmsAttrAttrgroupRelation implements Serializable {
    private static final long serialVersionUID = 573914349256422509L;
    /**
     * id
     */
    private Long id;
    /**
     * 属性id
     */
    private Long attrId;
    /**
     * 属性分组id
     */
    private Long attrGroupId;
    /**
     * 属性组内排序
     */
    private Integer attrSort;


}

