package com.kedom.common.entity.memberServiceEntity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
/**
 * 会员登录记录(UmsMemberLoginLog)实体类
 *
 * @author makejava
 * @since 2022-10-29 22:37:16
 */
public class UmsMemberLoginLog implements Serializable {
    private static final long serialVersionUID = -88675177556399022L;
    /**
     * id
     */
    private Long id;
    /**
     * member_id
     */
    private Long memberId;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * ip
     */
    private String ip;
    /**
     * city
     */
    private String city;
    /**
     * 登录类型[1-web，2-app]
     */
    private Integer loginType;


}

