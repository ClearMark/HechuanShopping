package com.kedom.productService.service;

import com.kedom.productService.entity.PmsAttrAttrgroupRelation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;

/**
 * 属性&属性分组关联(PmsAttrAttrgroupRelation)表服务接口
 *
 * @author makejava
 * @since 2022-11-17 14:25:16
 */
public interface PmsAttrAttrgroupRelationService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PmsAttrAttrgroupRelation queryById(Long id);

    /**
     * 新增数据
     *
     * @param pmsAttrAttrgroupRelation 实例对象
     * @return 实例对象
     */
    void insert(PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation);

    /**
     * 修改数据
     *
     * @param pmsAttrAttrgroupRelation 实例对象
     * @return 实例对象
     */
    void update(PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation);

   

}
