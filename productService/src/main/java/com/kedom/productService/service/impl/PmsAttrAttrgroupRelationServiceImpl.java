package com.kedom.productService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.productService.dao.PmsAttrAttrgroupRelationDao;
import com.kedom.productService.entity.PmsAttrAttrgroupRelation;
import com.kedom.productService.service.PmsAttrAttrgroupRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 属性&属性分组关联(PmsAttrAttrgroupRelation)表服务实现类
 *
 * @author makejava
 * @since 2022-11-17 14:25:16
 */
@Service("pmsAttrAttrgroupRelationService")
public class PmsAttrAttrgroupRelationServiceImpl implements PmsAttrAttrgroupRelationService {
    @Resource
    private PmsAttrAttrgroupRelationDao pmsAttrAttrgroupRelationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PmsAttrAttrgroupRelation queryById(Long id) {
       PmsAttrAttrgroupRelation obj=this.pmsAttrAttrgroupRelationDao.queryById(id);
     return obj;
    }

    /**
     * 新增数据
     *
     * @param pmsAttrAttrgroupRelation 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation) {
       int count= this.pmsAttrAttrgroupRelationDao.insert(pmsAttrAttrgroupRelation);
       if(count==0)
       {
           throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

    /**
     * 修改数据
     *
     * @param pmsAttrAttrgroupRelation 实例对象
     * @return 实例对象
     */
    @Override
    public void update(PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation) {
       int count= this.pmsAttrAttrgroupRelationDao.update(pmsAttrAttrgroupRelation);
       if(count==0)
       {
           throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

}
