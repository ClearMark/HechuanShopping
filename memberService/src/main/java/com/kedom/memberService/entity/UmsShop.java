package com.kedom.memberService.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
/**
 * 会员(UmsShop)实体类
 *
 * @author makejava
 * @since 2023-04-06 15:18:55
 */
public class UmsShop implements Serializable {
    private static final long serialVersionUID = -41942767364607286L;
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
    private Integer userId;
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

    private Integer notCheckId;


}

