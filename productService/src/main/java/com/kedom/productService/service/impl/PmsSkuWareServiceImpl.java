package com.kedom.productService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomUserException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.productService.dao.PmsSkuWareDao;
import com.kedom.productService.entity.PmsSkuWare;
import com.kedom.productService.service.PmsSkuInfoService;
import com.kedom.productService.service.PmsSkuWareService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 商品库存(PmsSkuWare)表服务实现类
 *
 * @author makejava
 * @since 2022-12-02 23:55:27
 */
@Service("pmsSkuWareService")
@Slf4j
public class PmsSkuWareServiceImpl implements PmsSkuWareService {
    @Resource
    private PmsSkuWareDao pmsSkuWareDao;
    @Resource
    private PmsSkuInfoService pmsSkuInfoService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PmsSkuWare queryById(Long id) {
        PmsSkuWare obj = this.pmsSkuWareDao.queryById(id);
        return obj;
    }

    /**
     * 新增数据
     * 商品第一次上架时，需要创建库存信息
     *
     * @param pmsSkuWare 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public void insert(PmsSkuWare pmsSkuWare) {

        //TODO: 1.校验是否已经存在库存信息
        //先查询上架商品的信息
        //       PmsSkuInfo intoWareSkuInfo = pmsSkuInfoService.querySkuIntoWareInfoBySkuId(pmsSkuWare.getSkuId());
        //未上架判断sku是否存在
//        Boolean bl1=pmsSkuInfoService.existsSkuBySkuId(pmsSkuWare.getSkuId())
        //存在在看操作人是不是sku的创建人
//        Long skuCreateId=pmsSkuInfoService.querySkuCreateIdBySkuId(pmsSkuWare.getSkuId());

        //插入
        int count = this.pmsSkuWareDao.insert(pmsSkuWare);
        if (count == 0) {
            throw new KedomUserException(KedomExceptionEnum.INSERT_ERROR);
        }
    }

    public Boolean existsSkuWareBySkuId(Long skuId) {
        Integer count = pmsSkuWareDao.existsSkuWareBySkuId(skuId);
        log.info("查询sku是否已经上架，skuId:{},count:{}", skuId, count);
        return count > 0;
    }


    /**
     * 修改数据
     *
     * @param pmsSkuWare 实例对象
     * @return 实例对象
     */
    @Override
    public void update(PmsSkuWare pmsSkuWare) {
        int count = this.pmsSkuWareDao.update(pmsSkuWare);
        if (count == 0) {
            throw new KedomUserException(KedomExceptionEnum.INSERT_ERROR);
        }
    }

}
