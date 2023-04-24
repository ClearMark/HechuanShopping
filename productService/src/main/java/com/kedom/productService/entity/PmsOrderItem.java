package com.kedom.productService.entity;

import lombok.Data;

import java.io.Serializable;


@Data
/**
 * 订单项信息(PmsOrderItem)实体类
 *
 * @author makejava
 * @since 2023-04-11 14:11:35
 */
public class PmsOrderItem implements Serializable {
    private static final long serialVersionUID = 433955728952429242L;
    /**
     * id
     */
    private Long id;
    /**
     * order_sn
     */
    private String orderSn;


    private String cancelString;
    /**
     * 商品分类id
     */
    private Long categoryId;

    /**
     * 商品sku编号
     */
    private Long skuId;
    /**
     * 商品sku名字
     */
    private String skuName;
    /**
     * 商品sku图片
     */
    private String skuImage;
    /**
     * 商品sku价格
     */
    private Double skuPrice;
    /**
     * 商品购买的数量
     */
    private Integer skuCount;
    /**
     * 商品销售属性组合（JSON）
     */
    private String skuAttrsVals;
    /**
     * 未发货/已发货/取消/完成
     */
    private String status;


}

