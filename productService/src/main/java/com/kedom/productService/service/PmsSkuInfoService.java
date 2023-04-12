package com.kedom.productService.service;

import com.kedom.productService.entity.GetProductByCategoryVO;
import com.kedom.productService.entity.PmsSkuInfo;
import com.kedom.productService.entity.SkuHotVO;
import com.kedom.productService.entity.vo.Sku;

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
    void insert(Sku pmsSkuInfo);

    /**
     * 修改数据
     *
     * @param pmsSkuInfo 实例对象
     * @return 实例对象
     */
    void update(PmsSkuInfo pmsSkuInfo);


    void insertGetKey(PmsSkuInfo pmsSkuInfo);

    Boolean existsSkuBySkuId(Long skuId);

    PmsSkuInfo querySkuIntoWareInfoBySkuId(Long skuId);


    List<Sku> getHotProduct(Integer offset, Integer limit);

    List<Sku> getProductByUserId(Long userId);

    void updateProduct(Sku sku);

    List<PmsSkuInfo> queryByKey(List<String> words, Integer offset);

    List<PmsSkuInfo> queryByCategory(GetProductByCategoryVO pamrs);

    List<PmsSkuInfo> getRecommendProductByUser(Integer userId, Integer offset, Integer limit);

    List<PmsSkuInfo> getSkuHot(SkuHotVO skuHotVO);
}
