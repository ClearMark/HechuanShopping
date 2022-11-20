package com.kedom.common.entity.productServiceEntity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;


@Data
/**
 * 商品三级分类(PmsCategory)实体类
 *
 * @author makejava
 * @since 2022-11-02 21:10:03
 */
public class PmsCategory implements Serializable {
    private static final long serialVersionUID = -75349091510728864L;
    /**
     * 分类id
     */
    private Long catId;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 父分类id
     */
    private Long parentCid;
    /**
     * 层级
     */
    private Integer catLevel;
    /**
     * 是否显示[0-不显示，1显示]
     */
    private Integer showStatus;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 图标地址
     */
    private String icon;
    /**
     * 计量单位
     */
    private String productUnit;
    /**
     * 商品数量
     */
    private Integer productCount;



    private ArrayList<PmsCategory> children;


}

