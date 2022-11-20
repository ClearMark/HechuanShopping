package com.kedom.productService.service;

import com.kedom.productService.entity.PmsAttrGroup;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 属性分组(PmsAttrGroup)表服务接口
 *
 * @author makejava
 * @since 2022-11-03 18:34:59
 */
public interface PmsAttrGroupService {

    /**
     * 通过ID查询单条数据
     *
     * @param attrGroupId 主键
     * @return 实例对象
     */
    PmsAttrGroup queryById(Long attrGroupId);

    /**
     * 新增数据
     *
     * @param pmsAttrGroup 实例对象
     * @return 实例对象
     */
    void insert(PmsAttrGroup pmsAttrGroup);


    void checkAttrGroupUniqueOnCategory(String attrGroupName, Long categoryId);

    /**
     * 修改数据
     *
     * @param pmsAttrGroup 实例对象
     * @return 实例对象
     */
    void update(PmsAttrGroup pmsAttrGroup);


    ArrayList<PmsAttrGroup> queryAttrGroupByCateGoryId(HashMap<String, Object> paramMap, Long cateGoryId);

    void checkAttrGroupIsExist(Integer attrGroupId);
}
