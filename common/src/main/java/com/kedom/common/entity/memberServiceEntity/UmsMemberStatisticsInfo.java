package com.kedom.common.entity.memberServiceEntity;

import lombok.Data;

import java.io.Serializable;


@Data
/**
 * 会员统计信息(UmsMemberStatisticsInfo)实体类
 *
 * @author makejava
 * @since 2022-10-29 22:37:16
 */
public class UmsMemberStatisticsInfo implements Serializable {
    private static final long serialVersionUID = 310676830133729038L;
    /**
     * id
     */
    private Long id;
    /**
     * 会员id
     */
    private Long memberId;
    /**
     * 累计消费金额
     */
    private Double consumeAmount;
    /**
     * 累计优惠金额
     */
    private Double couponAmount;
    /**
     * 订单数量
     */
    private Integer orderCount;
    /**
     * 优惠券数量
     */
    private Integer couponCount;
    /**
     * 评价数
     */
    private Integer commentCount;
    /**
     * 退货数量
     */
    private Integer returnOrderCount;
    /**
     * 登录次数
     */
    private Integer loginCount;
    /**
     * 关注数量
     */
    private Integer attendCount;
    /**
     * 粉丝数量
     */
    private Integer fansCount;
    /**
     * 收藏的商品数量
     */
    private Integer collectProductCount;
    /**
     * 收藏的专题活动数量
     */
    private Integer collectSubjectCount;
    /**
     * 收藏的评论数量
     */
    private Integer collectCommentCount;
    /**
     * 邀请的朋友数量
     */
    private Integer inviteFriendCount;


}

