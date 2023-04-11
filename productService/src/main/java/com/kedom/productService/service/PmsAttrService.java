package com.kedom.productService.service;

import com.kedom.productService.entity.PmsAttr;
import com.kedom.productService.entity.vo.CategoryAttrVO;

import java.util.List;

/**
 * 商品属性(PmsAttr)表服务接口
 *
 * @author makejava
 * @since 2022-11-04 10:51:15
 */
public interface PmsAttrService {

    /**
     * 通过ID查询单条数据
     *
     * @param attrId 主键
     * @return 实例对象
     */
    List<PmsAttr> queryById(Long attrId);

    /**
     * 新增数据
     *
     * @param pmsAttr 实例对象
     * @return 实例对象
     */
    void insert(PmsAttr pmsAttr);

    /**
     * 修改数据
     *
     * @param pmsAttr 实例对象
     * @return 实例对象
     */
    void update(PmsAttr pmsAttr);


    List<CategoryAttrVO> queryAllAttrNameByCateId(Long cateId);

    List<PmsAttr> getCategorySearchAttr(Long id);

    List<CategoryAttrVO> queryAllAttr(Integer num);

    void deleteAttrById(Long id);
}
