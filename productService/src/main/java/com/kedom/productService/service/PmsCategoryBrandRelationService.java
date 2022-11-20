package com.kedom.productService.service;

import com.kedom.productService.entity.PmsCategoryBrandRelation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;

/**
 * 品牌分类关联(PmsCategoryBrandRelation)表服务接口
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
public interface PmsCategoryBrandRelationService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PmsCategoryBrandRelation queryById(Long id);

    /**
     * 新增数据
     *
     * @param pmsCategoryBrandRelation 实例对象
     * @return 实例对象
     */
    void insert(PmsCategoryBrandRelation pmsCategoryBrandRelation);

    /**
     * 修改数据
     *
     * @param pmsCategoryBrandRelation 实例对象
     * @return 实例对象
     */
    void update(PmsCategoryBrandRelation pmsCategoryBrandRelation);

   

}
