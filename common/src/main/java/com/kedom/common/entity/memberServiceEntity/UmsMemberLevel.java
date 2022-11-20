package com.kedom.common.entity.memberServiceEntity;

import lombok.Data;

import java.io.Serializable;


@Data
/**
 * 会员等级(UmsMemberLevel)实体类
 *
 * @author makejava
 * @since 2022-10-29 22:37:16
 */
public class UmsMemberLevel implements Serializable {
    private static final long serialVersionUID = 823591498945982307L;
    /**
     * id
     */
    private Long id;
    /**
     * 等级名称
     */
    private String name;
    /**
     * 等级需要的成长值
     */
    private Integer growthPoint;
    /**
     * 是否为默认等级[0->不是；1->是]
     */
    private Integer defaultStatus;
    /**
     * 免运费标准
     */
    private Double freeFreightPoint;
    /**
     * 每次评价获取的成长值
     */
    private Integer commentGrowthPoint;
    /**
     * 是否有免邮特权
     */
    private Integer priviledgeFreeFreight;
    /**
     * 是否有会员价格特权
     */
    private Integer priviledgeMemberPrice;
    /**
     * 是否有生日特权
     */
    private Integer priviledgeBirthday;
    /**
     * 备注
     */
    private String note;


}

