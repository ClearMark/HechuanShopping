package com.kedom.productService.service;

import com.kedom.productService.entity.PmsSkuInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;

/**
 * sku信息(PmsSkuInfo)表服务接口
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
public interface PmsSkuInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param skuId 主键
     * @return 实例对象
     */
    PmsSkuInfo queryById(Long skuId);

    /**
     * 新增数据
     *
     * @param pmsSkuInfo 实例对象
     * @return 实例对象
     */
    void insert(PmsSkuInfo pmsSkuInfo);

    /**
     * 修改数据
     *
     * @param pmsSkuInfo 实例对象
     * @return 实例对象
     */
    void update(PmsSkuInfo pmsSkuInfo);


    void insertGetKey(PmsSkuInfo pmsSkuInfo);
}
