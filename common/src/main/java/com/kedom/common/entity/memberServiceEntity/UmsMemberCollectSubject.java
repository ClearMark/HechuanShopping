package com.kedom.common.entity.memberServiceEntity;

import lombok.Data;

import java.io.Serializable;


@Data
/**
 * 会员收藏的专题活动(UmsMemberCollectSubject)实体类
 *
 * @author makejava
 * @since 2022-10-29 22:37:16
 */
public class UmsMemberCollectSubject implements Serializable {
    private static final long serialVersionUID = 530737343948401656L;
    /**
     * id
     */
    private Long id;
    /**
     * subject_id
     */
    private Long subjectId;
    /**
     * subject_name
     */
    private String subjectName;
    /**
     * subject_img
     */
    private String subjectImg;
    /**
     * 活动url
     */
    private String subjectUrll;


}

