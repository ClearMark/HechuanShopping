package com.kedom.productService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.productService.dao.PmsAttrDao;
import com.kedom.productService.entity.PmsAttr;
import com.kedom.productService.entity.vo.CategoryAttrVO;
import com.kedom.productService.service.PmsAttrGroupService;
import com.kedom.productService.service.PmsAttrService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

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
    public List<PmsAttr> queryById(Long attrId) {
//        List<PmsAttr> obj=this.pmsAttrDao.queryById(attrId);
     return null;
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
//        pmsAttrGroupService.checkAttrGroupIsExist(pmsAttr.getAttrGroupId());
        //再判断是否有重复的属性
//        checkAttrIsExistAndEnable(pmsAttr.getAttrName(),pmsAttr.getAttrGroupId(),pmsAttr.getCatelogId());

        //添加属性
       int count= this.pmsAttrDao.insert(pmsAttr);
       if(count==0)
       {
           throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

    private void checkAttrIsExistAndEnable(String attrName, Integer attrGroupId, Long catelogId) {
        int count = pmsAttrDao.checkAttrIsExistAndEnable(attrName, attrGroupId,catelogId);
        if (count != 0) {
            throw new KedomException(KedomExceptionEnum.GROUP_ATTR_IS_EXIST);
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
           throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

    @Override
    public List<CategoryAttrVO> queryAllAttrNameByCateId(Long catelogId) {
        List<CategoryAttrVO> list = pmsAttrDao.queryAllAttrNameByCateId(catelogId);
        return list;
    }

    @Override
    public List<PmsAttr> getCategorySearchAttr(Long id) {

        return pmsAttrDao.getCategorySearchAttr(id);

    }

    @Override
    public List<CategoryAttrVO> queryAllAttr(Integer num) {
        int offset = (num - 1) * 10;
        List<CategoryAttrVO> categoryAttrVOS = pmsAttrDao.queryAllAttr(offset);
        return categoryAttrVOS;
    }

}
