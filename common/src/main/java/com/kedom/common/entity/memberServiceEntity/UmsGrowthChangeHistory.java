package com.kedom.common.entity.memberServiceEntity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
/**
 * 成长值变化历史记录(UmsGrowthChangeHistory)实体类
 *
 * @author makejava
 * @since 2022-10-29 22:37:15
 */
public class UmsGrowthChangeHistory implements Serializable {
    private static final long serialVersionUID = 802668475322190192L;
    /**
     * id
     */
    private Long id;
    /**
     * member_id
     */
    private Long memberId;
    /**
     * create_time
     */
    private LocalDateTime createTime;
    /**
     * 改变的值（正负计数）
     */
    private Integer changeCount;
    /**
     * 备注
     */
    private String note;
    /**
     * 积分来源[0-购物，1-管理员修改]
     */
    private Integer sourceType;


}

