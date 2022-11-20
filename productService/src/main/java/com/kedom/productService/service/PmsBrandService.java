package com.kedom.productService.service;


import com.kedom.common.entity.productServiceEntity.PmsBrand;

/**
 * 品牌(PmsBrand)表服务接口
 *
 * @author makejava
 * @since 2022-11-03 00:38:07
 */
public interface PmsBrandService {

    /**
     * 通过ID查询单条数据
     *
     * @param brandId 主键
     * @return 实例对象
     */
    PmsBrand queryById(Long brandId);

    /**
     * 新增数据
     *
     * @param pmsBrand 实例对象
     * @return 实例对象
     */
    void insert(PmsBrand pmsBrand);

    /**
     * 修改数据
     *
     * @param pmsBrand 实例对象
     * @return 实例对象
     */
    void update(PmsBrand pmsBrand);

   

}
