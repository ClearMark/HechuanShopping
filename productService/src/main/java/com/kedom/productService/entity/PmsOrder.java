package com.kedom.productService.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
/**
 * (PmsOrder)实体类
 *
 * @author makejava
 * @since 2023-04-11 14:11:34
 */
public class PmsOrder implements Serializable {
    private static final long serialVersionUID = -25186485039286921L;
    /**
     * id
     */
    private Long id;
    /**
     * member_id
     */
    private Long memberId;
    /**
     * 订单号
     */
    private String orderSn;
    /**
     * create_time
     */
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
     * 订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】
     */
    private String status;
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


}

