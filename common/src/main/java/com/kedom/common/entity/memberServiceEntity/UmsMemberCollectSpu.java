package com.kedom.common.entity.memberServiceEntity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
/**
 * 会员收藏的商品(UmsMemberCollectSpu)实体类
 *
 * @author makejava
 * @since 2022-10-29 22:37:16
 */
public class UmsMemberCollectSpu implements Serializable {
    private static final long serialVersionUID = 789661162244369493L;
    /**
     * id
     */
    private Long id;
    /**
     * 会员id
     */
    private Long memberId;
    /**
     * spu_id
     */
    private Long spuId;
    /**
     * spu_name
     */
    private String spuName;
    /**
     * spu_img
     */
    private String spuImg;
    /**
     * create_time
     */
    private LocalDateTime createTime;


}

