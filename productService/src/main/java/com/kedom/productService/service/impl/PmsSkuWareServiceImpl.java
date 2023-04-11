package com.kedom.productService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.productService.dao.PmsSkuWareDao;
import com.kedom.productService.entity.PmsSkuInfo;
import com.kedom.productService.entity.PmsSkuWare;
import com.kedom.productService.service.PmsSkuInfoService;
import com.kedom.productService.service.PmsSkuWareService;
import com.kedom.productService.util.IDUtil;
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
        if (existsSkuWareBySkuId(pmsSkuWare.getSkuId())) {
            throw new KedomException(KedomExceptionEnum.SKU_WARE_EXIST);
        }
        //校验Sku信息 创建人
        PmsSkuInfo pmsSkuInfo = pmsSkuInfoService.querySkuIntoWareInfoBySkuId(pmsSkuWare.getSkuId());
        if (pmsSkuInfo == null) {
            throw new KedomException(KedomExceptionEnum.SKU_NOT_EXIST);
        }
        if (!IDUtil.getId().equals(pmsSkuInfo.getCreateId())) {
            throw new KedomException(KedomExceptionEnum.SKU_INTO_WARE_ERROR_BY_CREATE_ID_ERROR);
        }
        pmsSkuWare.setSkuName(pmsSkuInfo.getSkuName());
        //插入
        int count = this.pmsSkuWareDao.insert(pmsSkuWare);
        if (count == 0) {
            throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
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


    }

    @Override
    public void updateWare(PmsSkuWare pmsSkuWare) {
        //先验证是否存在
        PmsSkuInfo pmsSkuInfo = pmsSkuInfoService.querySkuIntoWareInfoBySkuId(pmsSkuWare.getSkuId());
        if (pmsSkuInfo == null) {
            throw new KedomException(KedomExceptionEnum.SKU_NOT_EXIST);
        }
        if (!IDUtil.getId().equals(pmsSkuInfo.getCreateId())) {
            throw new KedomException(KedomExceptionEnum.SKU_INTO_WARE_ERROR_BY_CREATE_ID_ERROR);
        }

        Integer count = pmsSkuWareDao.updateWare(pmsSkuInfo);
        if (count == 0) {
            throw new KedomException(KedomExceptionEnum.UPDATE_ERROR);
        }

    }

    @Override
    public PmsSkuWare queryBySkuId(Long skuId) {

        PmsSkuWare pmsSkuWare = pmsSkuWareDao.queryBySkuId(skuId);
        return pmsSkuWare;
    }

}
