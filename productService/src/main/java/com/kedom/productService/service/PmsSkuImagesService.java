package com.kedom.productService.service;

import com.kedom.productService.entity.PmsSkuImages;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;

/**
 * sku图片(PmsSkuImages)表服务接口
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
public interface PmsSkuImagesService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PmsSkuImages queryById(Long id);

    /**
     * 新增数据
     *
     * @param pmsSkuImages 实例对象
     * @return 实例对象
     */
    void insert(PmsSkuImages pmsSkuImages);

    /**
     * 修改数据
     *
     * @param pmsSkuImages 实例对象
     * @return 实例对象
     */
    void update(PmsSkuImages pmsSkuImages);


    void insertList(List<PmsSkuImages> skuImages);
}
