package com.kedom.productService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomUserException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.productService.entity.PmsSkuInfo;
import com.kedom.productService.dao.PmsSkuInfoDao;
import com.kedom.productService.service.PmsSkuInfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;

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
    public void insert(PmsSkuInfo pmsSkuInfo) {
       int count= this.pmsSkuInfoDao.insert(pmsSkuInfo);
       if(count==0)
       {
       throw new KedomUserException(KedomExceptionEnum.INSERT_ERROR);
       }
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
        throw new KedomUserException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

    @Override
    public void insertGetKey(PmsSkuInfo pmsSkuInfo) {
        int count= this.pmsSkuInfoDao.insertGetKey(pmsSkuInfo);
        if(count==0)
        {
            throw new KedomUserException(KedomExceptionEnum.INSERT_ERROR);
        }
    }

}
