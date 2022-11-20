package com.kedom.productService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomUserException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.productService.entity.PmsProductAttrValue;
import com.kedom.productService.dao.PmsProductAttrValueDao;
import com.kedom.productService.service.PmsProductAttrValueService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;

/**
 * spu属性值(PmsProductAttrValue)表服务实现类
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
@Service("pmsProductAttrValueService")
public class PmsProductAttrValueServiceImpl implements PmsProductAttrValueService {
    @Resource
    private PmsProductAttrValueDao pmsProductAttrValueDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PmsProductAttrValue queryById(Long id) {
       PmsProductAttrValue obj=this.pmsProductAttrValueDao.queryById(id);
     return obj;
    }

    /**
     * 新增数据
     *
     * @param pmsProductAttrValue 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(PmsProductAttrValue pmsProductAttrValue) {
       int count= this.pmsProductAttrValueDao.insert(pmsProductAttrValue);
       if(count==0)
       {
       throw new KedomUserException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

    /**
     * 修改数据
     *
     * @param pmsProductAttrValue 实例对象
     * @return 实例对象
     */
    @Override
    public void update(PmsProductAttrValue pmsProductAttrValue) {
       int count= this.pmsProductAttrValueDao.update(pmsProductAttrValue);
       if(count==0)
       {
        throw new KedomUserException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

    @Override
    public void insertList(List<PmsProductAttrValue> skuAttrValues) {
        int count= this.pmsProductAttrValueDao.insertList(skuAttrValues);
        if(count==0)
        {
            throw new KedomUserException(KedomExceptionEnum.INSERT_ERROR);
        }
    }

}
