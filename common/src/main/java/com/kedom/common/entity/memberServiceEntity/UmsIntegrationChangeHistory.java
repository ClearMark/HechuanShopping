package com.kedom.common.entity.memberServiceEntity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
/**
 * 积分变化历史记录(UmsIntegrationChangeHistory)实体类
 *
 * @author makejava
 * @since 2022-10-29 22:37:16
 */
public class UmsIntegrationChangeHistory implements Serializable {
    private static final long serialVersionUID = -87585538749765092L;
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
     * 变化的值
     */
    private Integer changeCount;
    /**
     * 备注
     */
    private String note;
    /**
     * 来源[0->购物；1->管理员修改;2->活动]
     */
    private Integer sourceTyoe;


}

