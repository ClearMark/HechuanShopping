package com.kedom.productService.service;

import com.kedom.productService.entity.PmsRecommendProduct;

/**
 * (PmsRecommendProduct)表服务接口
 *
 * @author makejava
 * @since 2023-04-10 14:07:40
 */
public interface PmsRecommendProductService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PmsRecommendProduct queryById(Integer id);

    /**
     * 新增数据
     *
     * @param pmsRecommendProduct 实例对象
     * @return 实例对象
     */
    void insert(PmsRecommendProduct pmsRecommendProduct);

    /**
     * 修改数据
     *
     * @param pmsRecommendProduct 实例对象
     * @return 实例对象
     */
    void update(PmsRecommendProduct pmsRecommendProduct);


}
