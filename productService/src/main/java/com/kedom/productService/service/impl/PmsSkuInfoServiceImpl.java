package com.kedom.productService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.productService.dao.PmsSkuInfoDao;
import com.kedom.productService.entity.PmsSkuInfo;
import com.kedom.productService.entity.vo.Sku;
import com.kedom.productService.service.PmsSkuInfoService;
import com.kedom.productService.service.PmsSkuSaleAttrValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * sku信息(PmsSkuInfo)表服务实现类
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
@Service("pmsSkuInfoService")
public class PmsSkuInfoServiceImpl implements PmsSkuInfoService {
    @Resource
    private PmsSkuInfoDao pmsSkuInfoDao;


    @Resource
    private PmsSkuSaleAttrValueService pmsSkuSaleAttrValueService;

    /**
     * 通过ID查询单条数据
     *
     * @param skuId 主键
     * @return 实例对象
     */
    @Override
    public PmsSkuInfo queryById(Long skuId) {
       PmsSkuInfo obj=this.pmsSkuInfoDao.queryById(skuId);
     return obj;
    }

    /**
     * 新增数据
     *
     * @param pmsSkuInfo 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(Sku pmsSkuInfo) {
       int count= this.pmsSkuInfoDao.insert(pmsSkuInfo);
        pmsSkuSaleAttrValueService.insertBatch(pmsSkuInfo.getAttr(), pmsSkuInfo.getSkuId());


    }

    /**
     * 修改数据
     *
     * @param pmsSkuInfo 实例对象
     * @return 实例对象
     */
    @Override
    public void update(PmsSkuInfo pmsSkuInfo) {
       int count= this.pmsSkuInfoDao.update(pmsSkuInfo);
       if(count==0)
       {
           throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

    @Override
    public void insertGetKey(PmsSkuInfo pmsSkuInfo) {
        int count = this.pmsSkuInfoDao.insertGetKey(pmsSkuInfo);
        if (count == 0) {
            throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
        }
    }

    @Override
    public Boolean existsSkuBySkuId(Long skuId) {
        Integer count = pmsSkuInfoDao.existsSkuBySkuId(skuId);
        if (count.equals(1)) {
            return true;
        }
        return false;
    }

    @Override
    public PmsSkuInfo querySkuIntoWareInfoBySkuId(Long skuId) {
        PmsSkuInfo pmsSkuInfo = pmsSkuInfoDao.querySkuIntoWareInfoBySkuId(skuId);
        return pmsSkuInfo;
    }

    @Override
    public List<Sku> getHotProduct() {
        return pmsSkuInfoDao.getHotProduct();
    }

    @Override
    public List<Sku> getProductByUserId(Long userId) {

        return pmsSkuInfoDao.getProductByUserId(userId);
    }

}
