package com.kedom.common.entity.productServiceEntity;

import lombok.Data;

import java.io.Serializable;


@Data
/**
 * 品牌(PmsBrand)实体类
 *
 * @author makejava
 * @since 2022-11-03 00:38:07
 */
public class PmsBrand implements Serializable {
    private static final long serialVersionUID = -93885096073248275L;
    /**
     * 品牌id
     */
    private Long brandId;
    /**
     * 品牌名
     */
    private String name;
    /**
     * 品牌logo地址
     */
    private String logo;
    /**
     * 介绍
     */
    private String descript;
    /**
     * 显示状态[0-不显示；1-显示]
     */
    private Integer showStatus;
    /**
     * 检索首字母
     */
    private String firstLetter;
    /**
     * 排序
     */
    private Integer sort;


}

