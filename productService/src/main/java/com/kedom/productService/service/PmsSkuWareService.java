package com.kedom.productService.service;

import com.kedom.productService.entity.PmsSkuWare;

/**
 * 商品库存(PmsSkuWare)表服务接口
 *
 * @author makejava
 * @since 2022-12-02 23:55:27
 */
public interface PmsSkuWareService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PmsSkuWare queryById(Long id);

    /**
     * 新增数据
     *
     * @param pmsSkuWare 实例对象
     * @return 实例对象
     */
    void insert(PmsSkuWare pmsSkuWare);

    /**
     * 修改数据
     *
     * @param pmsSkuWare 实例对象
     * @return 实例对象
     */
    void update(PmsSkuWare pmsSkuWare);

    void updateWare(PmsSkuWare pmsSkuWare);

    PmsSkuWare queryBySkuId(Long skuId);
}
