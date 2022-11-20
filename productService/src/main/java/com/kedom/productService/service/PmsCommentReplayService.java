package com.kedom.productService.service;

import com.kedom.productService.entity.PmsCommentReplay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;

/**
 * 商品评价回复关系(PmsCommentReplay)表服务接口
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
public interface PmsCommentReplayService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PmsCommentReplay queryById(Long id);

    /**
     * 新增数据
     *
     * @param pmsCommentReplay 实例对象
     * @return 实例对象
     */
    void insert(PmsCommentReplay pmsCommentReplay);

    /**
     * 修改数据
     *
     * @param pmsCommentReplay 实例对象
     * @return 实例对象
     */
    void update(PmsCommentReplay pmsCommentReplay);

   

}
