package com.kedom.memberService.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShopInfoVO {
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

    private String idCardFront;

    private String idCardBack;

    private String permitFront;

    private String permitBack;

}
