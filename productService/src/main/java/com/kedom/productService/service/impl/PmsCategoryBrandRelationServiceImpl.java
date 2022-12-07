package com.kedom.productService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.productService.dao.PmsCategoryBrandRelationDao;
import com.kedom.productService.entity.PmsCategoryBrandRelation;
import com.kedom.productService.service.PmsCategoryBrandRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 品牌分类关联(PmsCategoryBrandRelation)表服务实现类
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
@Service("pmsCategoryBrandRelationService")
public class PmsCategoryBrandRelationServiceImpl implements PmsCategoryBrandRelationService {
    @Resource
    private PmsCategoryBrandRelationDao pmsCategoryBrandRelationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PmsCategoryBrandRelation queryById(Long id) {
       PmsCategoryBrandRelation obj=this.pmsCategoryBrandRelationDao.queryById(id);
     return obj;
    }

    /**
     * 新增数据
     *
     * @param pmsCategoryBrandRelation 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(PmsCategoryBrandRelation pmsCategoryBrandRelation) {
       int count= this.pmsCategoryBrandRelationDao.insert(pmsCategoryBrandRelation);
       if(count==0)
       {
           throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

    /**
     * 修改数据
     *
     * @param pmsCategoryBrandRelation 实例对象
     * @return 实例对象
     */
    @Override
    public void update(PmsCategoryBrandRelation pmsCategoryBrandRelation) {
       int count= this.pmsCategoryBrandRelationDao.update(pmsCategoryBrandRelation);
       if(count==0)
       {
           throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

}
