package com.kedom.productService.entity;

import java.io.Serializable;
import lombok.Data;


@Data
/**
 * 商品评价回复关系(PmsCommentReplay)实体类
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
public class PmsCommentReplay implements Serializable {
    private static final long serialVersionUID = 495861112309903762L;
    /**
     * id
     */
    private Long id;
    /**
     * 评论id
     */
    private Long commentId;
    /**
     * 回复id
     */
    private Long replyId;


}

