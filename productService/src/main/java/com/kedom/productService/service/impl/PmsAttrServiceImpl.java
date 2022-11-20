package com.kedom.productService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomUserException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.productService.entity.PmsAttr;
import com.kedom.productService.dao.PmsAttrDao;
import com.kedom.productService.service.PmsAttrGroupService;
import com.kedom.productService.service.PmsAttrService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;

/**
 * 商品属性(PmsAttr)表服务实现类
 *
 * @author makejava
 * @since 2022-11-04 10:51:15
 */
@Service("pmsAttrService")
public class PmsAttrServiceImpl implements PmsAttrService {
    @Resource
    private PmsAttrDao pmsAttrDao;

    @Resource
    private PmsAttrGroupService pmsAttrGroupService;

    /**
     * 通过ID查询单条数据
     *
     * @param attrId 主键
     * @return 实例对象
     */
    @Override
    public PmsAttr queryById(Long attrId) {
       PmsAttr obj=this.pmsAttrDao.queryById(attrId);
     return obj;
    }

    /**
     * 新增数据
     *
     * @param pmsAttr 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(PmsAttr pmsAttr) {
        //先判断是否有对应分组
        pmsAttrGroupService.checkAttrGroupIsExist(pmsAttr.getAttrGroupId());
        //再判断是否有重复的属性
        checkAttrIsExistAndEnable(pmsAttr.getAttrName(),pmsAttr.getAttrGroupId(),pmsAttr.getCatelogId());

        //添加属性
       int count= this.pmsAttrDao.insert(pmsAttr);
       if(count==0)
       {
       throw new KedomUserException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

    private void checkAttrIsExistAndEnable(String attrName, Integer attrGroupId, Long catelogId) {
        int count = pmsAttrDao.checkAttrIsExistAndEnable(attrName, attrGroupId,catelogId);
        if (count != 0) {
            throw new KedomUserException(KedomExceptionEnum.GROUP_ATTR_IS_EXIST);
        }
    }

    /**
     * 修改数据
     *
     * @param pmsAttr 实例对象
     * @return 实例对象
     */
    @Override
    public void update(PmsAttr pmsAttr) {
       int count= this.pmsAttrDao.update(pmsAttr);
       if(count==0)
       {
        throw new KedomUserException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

    @Override
    public HashMap<Long, PmsAttr> queryAllAttrNameByCateId(Long catelogId,int type) {
        HashMap<Long,PmsAttr> map = pmsAttrDao.queryAllAttrNameByCateId(catelogId,type);
        return map;
    }

}
