package com.kedom.productService.service;

import com.kedom.productService.entity.PmsProductAttrValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;

/**
 * spu属性值(PmsProductAttrValue)表服务接口
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
public interface PmsProductAttrValueService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PmsProductAttrValue queryById(Long id);

    /**
     * 新增数据
     *
     * @param pmsProductAttrValue 实例对象
     * @return 实例对象
     */
    void insert(PmsProductAttrValue pmsProductAttrValue);

    /**
     * 修改数据
     *
     * @param pmsProductAttrValue 实例对象
     * @return 实例对象
     */
    void update(PmsProductAttrValue pmsProductAttrValue);


    void insertList(List<PmsProductAttrValue> skuAttrValues);
}
