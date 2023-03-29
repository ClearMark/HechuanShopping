package com.kedom.productService.service;

import com.kedom.productService.entity.PmsSkuSaleAttrValue;
import com.kedom.productService.entity.vo.Attr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;

/**
 * sku销售属性&值(PmsSkuSaleAttrValue)表服务接口
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
public interface PmsSkuSaleAttrValueService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PmsSkuSaleAttrValue queryById(Long id);

    /**
     * 新增数据
     *
     * @param pmsSkuSaleAttrValue 实例对象
     * @return 实例对象
     */
    void insert(PmsSkuSaleAttrValue pmsSkuSaleAttrValue);

    /**
     * 修改数据
     *
     * @param pmsSkuSaleAttrValue 实例对象
     * @return 实例对象
     */
    void update(PmsSkuSaleAttrValue pmsSkuSaleAttrValue);


    void insertList(List<PmsSkuSaleAttrValue> skuSaleAttrValues);

    void insertBatch(List<Attr> attr, Long skuId);
}
