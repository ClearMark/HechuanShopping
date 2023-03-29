package com.kedom.sellService.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;


@Data
/**
 * 会员(SmsShop)实体类
 *
 * @author makejava
 * @since 2023-02-28 10:27:24
 */
public class SmsShop implements Serializable {
    private static final long serialVersionUID = 951457387705740369L;
    /**
     * id
     */
    private Long id;
    /**
     * 会员等级id
     */
    private Long levelId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 注册时间
     */
    private LocalDateTime createTime;
    /**
     * 店铺名
     */
    private String shopName;
    /**
     * 商品数
     */
    private Integer goodsNum;
    /**
     * 关注数
     */
    private Integer followNum;


}

