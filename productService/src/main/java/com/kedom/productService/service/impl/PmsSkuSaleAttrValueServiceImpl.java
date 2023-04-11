package com.kedom.productService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.productService.dao.PmsSkuSaleAttrValueDao;
import com.kedom.productService.entity.PmsSkuSaleAttrValue;
import com.kedom.productService.entity.vo.Attr;
import com.kedom.productService.service.PmsSkuSaleAttrValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * sku销售属性&值(PmsSkuSaleAttrValue)表服务实现类
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
@Service("pmsSkuSaleAttrValueService")
public class PmsSkuSaleAttrValueServiceImpl implements PmsSkuSaleAttrValueService {
    @Resource
    private PmsSkuSaleAttrValueDao pmsSkuSaleAttrValueDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PmsSkuSaleAttrValue queryById(Long id) {
       PmsSkuSaleAttrValue obj=this.pmsSkuSaleAttrValueDao.queryById(id);
     return obj;
    }

    /**
     * 新增数据
     *
     * @param pmsSkuSaleAttrValue 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(PmsSkuSaleAttrValue pmsSkuSaleAttrValue) {
       int count= this.pmsSkuSaleAttrValueDao.insert(pmsSkuSaleAttrValue);
       if(count==0)
       {
           throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

    /**
     * 修改数据
     *
     * @param pmsSkuSaleAttrValue 实例对象
     * @return 实例对象
     */
    @Override
    public void update(PmsSkuSaleAttrValue pmsSkuSaleAttrValue) {
       int count= this.pmsSkuSaleAttrValueDao.update(pmsSkuSaleAttrValue);
       if(count==0)
       {
           throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

    @Override
    public void insertList(List<PmsSkuSaleAttrValue> skuSaleAttrValues) {
        int count= this.pmsSkuSaleAttrValueDao.insertList(skuSaleAttrValues);
        if(count==0)
        {
            throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
        }
    }

    @Override
    public void insertBatch(List<Attr> attr, Long skuId) {
        Integer integer = pmsSkuSaleAttrValueDao.insertBatch(attr, skuId);
        if (integer == 0) {
            throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
        }
    }

    @Override
    public List<PmsSkuSaleAttrValue> queryBySkuId(Long skuId) {

        return pmsSkuSaleAttrValueDao.queryBySkuId(skuId);
    }

    @Override
    public void updateAttr(Attr attr, Long skuId) {
        pmsSkuSaleAttrValueDao.updateAttr(attr, skuId);
    }

}
