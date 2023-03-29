package com.kedom.productService.service;


import com.kedom.common.entity.productServiceEntity.PmsCategory;
import com.kedom.productService.entity.PmsCategoryAfter;
import com.kedom.productService.entity.controllerVo.pmsCategory.CateAdePageVO;

import java.util.List;

/**
 * 商品三级分类(PmsCategory)表服务接口
 *
 * @author makejava
 * @since 2022-11-02 21:10:04
 */
public interface PmsCategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param catId 主键
     * @return 实例对象
     */
    PmsCategory queryById(Long catId);


    /**
     * 新增数据
     *
     * @param pmsCategory 实例对象
     * @return 实例对象
     */
    void insert(PmsCategory pmsCategory);

    /**
     * 修改数据
     *
     * @param pmsCategory 实例对象
     * @return 实例对象
     */
    Byte update(PmsCategory pmsCategory);

    /**
     * 通过主键删除数据
     *
     * @param catId 主键
     * @return 是否成功
     */
    Byte deleteById(Long catId);

    List<PmsCategory> getAllProductCategory();

    void removeCategoryById(List<Long> ids);

    void checkCategoryIsThereLevelCategory(Long cateId);

    List<PmsCategory> getProductCategory(CateAdePageVO cateAdePageVO);

    Integer getProductCategoryCount(PmsCategory pmsCategory);

    List<PmsCategoryAfter> getAllProductCategoryCase();
}
