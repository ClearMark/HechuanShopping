package com.kedom.productService.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class OrderItemVO {
    private Long id;
    /**
     * member_id
     */
    private Long memberId;
    /**
     * 订单号
     */
    private String orderSn;

    private String cancelString;
    /**
     * create_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    /**
     * 订单总额
     */
    private Double totalAmount;
    /**
     * 运费金额
     */
    private Double freightAmount;
    /**
     * 收货人姓名
     */
    private String receiverName;
    /**
     * 收货人电话
     */
    private String receiverPhone;
    /**
     * 收货人邮编
     */
    private String receiverPostCode;
    /**
     * 省份/直辖市
     */
    private String receiverProvince;
    /**
     * 城市
     */
    private String receiverCity;
    /**
     * 区
     */
    private String receiverRegion;
    /**
     * 详细地址
     */
    private String receiverDetailAddress;
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

    private Integer total;
    /**
     * 未发货/已发货/取消/完成
     */
    private String status;

}
