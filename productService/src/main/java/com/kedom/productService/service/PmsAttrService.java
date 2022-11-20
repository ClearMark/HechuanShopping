package com.kedom.productService.service;

import com.kedom.productService.entity.PmsAttr;
import org.apache.ibatis.annotations.MapKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    PmsAttr queryById(Long attrId);

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


    HashMap<Long, PmsAttr> queryAllAttrNameByCateId(Long cateId,int type);
}
