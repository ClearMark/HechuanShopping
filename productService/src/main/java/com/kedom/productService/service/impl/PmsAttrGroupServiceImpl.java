package com.kedom.productService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.productService.dao.PmsAttrGroupDao;
import com.kedom.productService.entity.PmsAttrGroup;
import com.kedom.productService.service.PmsAttrGroupService;
import com.kedom.productService.service.PmsCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 属性分组(PmsAttrGroup)表服务实现类
 *
 * @author makejava
 * @since 2022-11-03 18:34:59
 */
@Service("pmsAttrGroupService")
public class PmsAttrGroupServiceImpl implements PmsAttrGroupService {
    @Resource
    private PmsAttrGroupDao pmsAttrGroupDao;

    @Resource
    private PmsCategoryService pmsCategoryService;

    /**
     * 通过ID查询单条数据
     *
     * @param attrGroupId 主键
     * @return 实例对象
     */
    @Override
    public PmsAttrGroup queryById(Long attrGroupId) {
       PmsAttrGroup obj=this.pmsAttrGroupDao.queryById(attrGroupId);
     return obj;
    }

    /**
     * 新增数据
     *
     * @param pmsAttrGroup 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(PmsAttrGroup pmsAttrGroup) {
        //确认3级标题
        pmsCategoryService.checkCategoryIsThereLevelCategory(pmsAttrGroup.getCatelogId());
        checkAttrGroupUniqueOnCategory(pmsAttrGroup.getAttrGroupName(),pmsAttrGroup.getCatelogId());


       int count= this.pmsAttrGroupDao.insert(pmsAttrGroup);
       if(count==0)
       {
           throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
       }
    }




    @Override
    public void checkAttrGroupUniqueOnCategory(String attrGroupName, Long categoryId) {
        int count= this.pmsAttrGroupDao.checkAttrGroupUniqueOnCategory(attrGroupName,categoryId);
        if(count!=0)
        {
            throw new KedomException(KedomExceptionEnum.AttrGroupNotUniqueOnCategory);
        }
    }



    /**
     * 修改数据
     *
     * @param pmsAttrGroup 实例对象
     * @return 实例对象
     */
    @Override
    public void update(PmsAttrGroup pmsAttrGroup) {
       int count= this.pmsAttrGroupDao.update(pmsAttrGroup);
       if(count==0)
       {
           throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

    @Override
    public ArrayList<PmsAttrGroup> queryAttrGroupByCateGoryId(HashMap<String, Object> paramMap, Long cateGoryId) {
        String name = paramMap.get("name").toString();

        ArrayList<PmsAttrGroup> pmsAttrGroups=pmsAttrGroupDao.queryAttrGroupByCateGoryId(name,cateGoryId);
        return pmsAttrGroups;

    }

    @Override
    public void checkAttrGroupIsExist(Integer attrGroupId) {
        int count=pmsAttrGroupDao.checkAttrGroupIsExist(attrGroupId);
        if (count ==0)
        {
            throw new KedomException(KedomExceptionEnum.AttrGroupNotIsExist);
        }
    }

}
